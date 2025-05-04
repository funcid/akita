package me.func.akita

import me.func.akita.service.DeviceService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AkitaApplicationTests {
    @Autowired
    private lateinit var deviceService: DeviceService

    @Test
    fun `should get all light devices`() {
        val lightDevices = deviceService.getAllLightDevices()
        assert(lightDevices.isNotEmpty()) { "No light devices found" }
    }

    @Test
    fun `should switch light device`() {
        val lightDevices = deviceService.getAllLightDevices()
        if (lightDevices.isNotEmpty()) {
            val firstDevice = lightDevices.first()
            deviceService.switchLight(firstDevice.id, true)
        }
    }

    @Test
    fun `should turn all lights on`() {
        val lightDevices = deviceService.getAllLightDevices()
        assert(lightDevices.isNotEmpty()) { "No light devices found" }

        lightDevices.forEach { device ->
            deviceService.switchLight(device.id, true)
        }
    }

    @Test
    fun `should turn all lights off`() {
        val lightDevices = deviceService.getAllLightDevices()
        assert(lightDevices.isNotEmpty()) { "No light devices found" }

        lightDevices.forEach { device ->
            deviceService.switchLight(device.id, false)
        }
    }

    @Test
    fun `should set first light to dark green`() {
        val lightDevices = deviceService.getAllLightDevices()
        assert(lightDevices.isNotEmpty()) { "No light devices found" }

        lightDevices.forEach {
            deviceService.setColor(it.id, 220, 99, 99)
        }
    }
}
