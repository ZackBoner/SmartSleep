package com.example.smartsleepalpha;

import androidx.appcompat.app.AppCompatActivity;
import com.example.smartsleepalpha.databinding.ActivityMainBinding;
import com.google.android.libraries.healthdata.HealthDataClient;
import com.google.android.libraries.healthdata.HealthDataService;
import com.google.android.libraries.healthdata.permission.Permission;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Set;

import javax.annotation.ParametersAreNonnullByDefault;

public class MainActivity extends AppCompatActivity {
    public static final String APP_TAG = "SmartSleep";
    private SleepReader sleepReader = null;
    private Permissions permissions = null;

    private Button setAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
        setAlarmButton = binding.button;

        if (!HealthDataService.isHealthDataApiSupported()) {
            Toast.makeText(
                    this,
                    "Health Platform not available, make sure you're on Samsung device running Android"
                            + " Watch 4 and above",
                    Toast.LENGTH_LONG)
                    .show();
            finish();
        }

        HealthDataClient healthDataClient = HealthDataService.getClient(this);
        sleepReader = new SleepReader(healthDataClient);
        permissions = new Permissions(healthDataClient);

        readSleepWithPermissionsCheck();
        */
    }

    private void readSleepWithPermissionsCheck() {
        /**
        try {
            ListenableFuture<Set<Permission>> permissionFuture = permissions.getGrantedPermissions();
            Futures.addCallback(permissionFuture, new FutureCallback<Set<Permission>>() {
                @Override
                public void onSuccess(@Nullable Set<Permission> result) {
                    if (permissions.arePermissionsGranted(result)) {
                        Log.d(APP_TAG, "All permissions granted. Read steps.");
                        readSleep();
                    } else {
                        Log.d(APP_TAG, "Permissions not granted. Request Permissions.");
                        readSleepWithRequestPermissions();
                    }
                }

                @Override
                @ParametersAreNonnullByDefault
                public void onFailure(Throwable t) { onPermissionsFailureHandler(t); }

                }
            });

        }*/
        return;
    }
}