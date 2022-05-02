package com.example.smartsleepalpha;

import androidx.annotation.Nullable;
import com.google.android.libraries.healthdata.HealthDataClient;
import com.google.android.libraries.healthdata.data.AggregatedValue;
import com.google.android.libraries.healthdata.data.CumulativeAggregationSpec;
import com.google.android.libraries.healthdata.data.CumulativeData;
import com.google.android.libraries.healthdata.data.IntervalDataTypes;
import com.google.android.libraries.healthdata.data.ReadAggregatedDataRequest;
import com.google.android.libraries.healthdata.data.ReadAggregatedDataResponse;
import com.google.android.libraries.healthdata.data.TimeSpec;
import com.google.common.util.concurrent.ListenableFuture;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class SleepReader {
    private final HealthDataClient healthDataClient;

    SleepReader(HealthDataClient healthDC) { healthDataClient = healthDC; }

    public ListenableFuture<ReadAggregatedDataResponse> readAggregatedData() throws SleepReaderException {
        if (healthDataClient == null) {
            throw new SleepReaderException("health client is null");
        }
        ReadAggregatedDataRequest readAggregatedDataRequest = ReadAggregatedDataRequest.builder()
                .setTimeSpec(
                        TimeSpec.builder()
                                .setStartLocalDateTime(LocalDateTime.now().with(LocalTime.MIDNIGHT))
                                .build())
                .addCumulativeAggregationSpec(
                        CumulativeAggregationSpec.builder(IntervalDataTypes.SLEEP_STAGE).build())
                .build();
        return healthDataClient.readAggregatedData(readAggregatedDataRequest);
    }

    public long readSleepFromAggregatedDataResponse(@Nullable ReadAggregatedDataResponse result) {
        if (result != null) {
            List<CumulativeData> cumulativeDataList = result.getCumulativeDataList();
            if (!cumulativeDataList.isEmpty()) {
                for (CumulativeData cumulativeData : cumulativeDataList) {
                    AggregatedValue aggregatedValue = cumulativeData.getTotal();
                    if (aggregatedValue != null) {

                    }
                }
            }
        }
        return 0;
    }

}








