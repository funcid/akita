package me.func.akita.service

import me.func.akita.dto.req.Capability
import me.func.akita.dto.req.ColorRequest
import me.func.akita.dto.req.Device
import me.func.akita.dto.req.LightSwitchRequest
import me.func.akita.ports.YandexApiClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DeviceService(
    private val yandexApiClient: YandexApiClient,
) {
    private val logger = LoggerFactory.getLogger(DeviceService::class.java)

    fun getAllLightDevices() =
        yandexApiClient.getUserInfo().devices?.filter {
            it.type == "devices.types.light"
        } ?: emptyList()

    fun switchLight(
        deviceId: String,
        turnOn: Boolean,
    ) {
        logger.info("Switching light device {} to {}", deviceId, if (turnOn) "ON" else "OFF")

        val body =
            LightSwitchRequest(
                devices =
                    listOf(
                        Device(
                            id = deviceId,
                            actions =
                                listOf(
                                    Capability(
                                        type = "devices.capabilities.on_off",
                                        state =
                                            mapOf(
                                                "instance" to "on",
                                                "value" to turnOn,
                                            ),
                                    ),
                                ),
                        ),
                    ),
            )

        try {
            yandexApiClient.lightSwitch(body)
            logger.info("Successfully switched light device {}", deviceId)
        } catch (e: Exception) {
            logger.error("Failed to switch light device {}: {}", deviceId, e.message, e)
        }
    }

    fun setColor(
        deviceId: String,
        h: Int,
        s: Int,
        v: Int,
    ) {
        logger.info("Setting color for device {} to HSV({}, {}, {})", deviceId, h, s, v)

        val body =
            ColorRequest(
                devices =
                    listOf(
                        Device(
                            id = deviceId,
                            actions =
                                listOf(
                                    Capability(
                                        type = "devices.capabilities.color_setting",
                                        state =
                                            mapOf(
                                                "instance" to "hsv",
                                                "value" to
                                                    mapOf(
                                                        "h" to h,
                                                        "s" to s,
                                                        "v" to v,
                                                    ),
                                            ),
                                    ),
                                ),
                        ),
                    ),
            )

        try {
            yandexApiClient.setColor(body)
            logger.info("Successfully set color for device {}", deviceId)
        } catch (e: Exception) {
            logger.error("Failed to set color for device {}: {}", deviceId, e.message, e)
        }
    }
}
