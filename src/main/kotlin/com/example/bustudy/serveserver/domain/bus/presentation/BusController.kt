package com.example.bustudy.serveserver.domain.bus.presentation

import com.example.bustudy.serveserver.domain.bus.presentation.dto.request.GenerateEstimatedTimeRequest
import com.example.bustudy.serveserver.domain.bus.presentation.dto.response.GenerateEstimatedTimeResponse
import com.example.bustudy.serveserver.domain.bus.service.GenerateEstimatedTimeService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bus")
class BusController(
    private val generateEstimatedTimeService: GenerateEstimatedTimeService
) {

    @PostMapping
    fun generateEstimatedTime(
        @RequestBody @Valid request: GenerateEstimatedTimeRequest
    ): GenerateEstimatedTimeResponse {
        return generateEstimatedTimeService.execute(request)
    }
}