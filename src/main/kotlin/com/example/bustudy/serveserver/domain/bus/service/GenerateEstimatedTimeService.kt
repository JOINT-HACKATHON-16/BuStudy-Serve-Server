package com.example.bustudy.serveserver.domain.bus.service

import com.example.bustudy.serveserver.domain.bus.presentation.dto.request.GenerateEstimatedTimeRequest
import com.example.bustudy.serveserver.domain.bus.presentation.dto.response.GenerateEstimatedTimeResponse
import com.example.bustudy.serveserver.infrastructure.feign.client.odsay.OdSayClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GenerateEstimatedTimeService(
    private val odSayClient: OdSayClient
) {

    @Value("\${app.od-say.api-key}")
    lateinit var odSayApiKey: String

    fun execute(request: GenerateEstimatedTimeRequest): GenerateEstimatedTimeResponse {
        val estimatedTime = odSayClient.searchPubTransPathT(
            odSayApiKey,
            request.sx,
            request.sy,
            request.arrivalX,
            request.arrivalY
        )

        return GenerateEstimatedTimeResponse(estimatedTime.totalTime)
    }
}