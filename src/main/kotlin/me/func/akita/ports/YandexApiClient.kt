package me.func.akita.ports

import me.func.akita.dto.req.ColorRequest
import me.func.akita.dto.req.LightSwitchRequest
import me.func.akita.dto.resp.SmartHomeResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    value = "yandex-api",
    url = "\${yandex-api.url}",
    configuration = [YandexApiConfig::class],
)
interface YandexApiClient {
    @GetMapping(
        value = ["/v1.0/user/info"],
    )
    fun getUserInfo(): SmartHomeResponse

    @PostMapping(
        value = ["/v1.0/devices/actions"],
        produces = ["application/json"],
    )
    fun lightSwitch(
        @RequestBody lightSwitchRequest: LightSwitchRequest,
    )

    @PostMapping(
        value = ["/v1.0/devices/actions"],
        produces = ["application/json"],
    )
    fun setColor(
        @RequestBody colorRequest: ColorRequest,
    )
}
