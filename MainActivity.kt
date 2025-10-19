package com.jym.supervpn

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

/**
 * JYM Super VPN - MainActivity (template)
 *
 * This is a safe, legal template. IT DOES NOT include any code to bypass carrier
 * billing or connect to unauthorized "free" servers. Implement a VPN backend
 * (WireGuard/OpenVPN) and perform any server connections only with authorization.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var statusText: TextView
    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    private val prepareVpn =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                statusText.text = "VPN permission granted. Ready to start."
            } else {
                statusText.text = "VPN permission denied."
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusText = findViewById(R.id.statusText)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)

        btnStart.setOnClickListener {
            val intent = VpnService.prepare(this)
            if (intent != null) {
                // Ask user for permission to start a VPN connection
                prepareVpn.launch(intent)
            } else {
                // Permission already granted — start the VPN
                startVpn()
            }
        }

        btnStop.setOnClickListener {
            stopVpn()
        }
    }

    private fun startVpn() {
        // TODO: Integrate with a VPN backend (WireGuard/OpenVPN).
        // This method should create or load a configuration, then start the underlying
        // VPN engine. Examples:
        //  - For WireGuard: use the WireGuard Android library or the wg-quick approach.
        //  - For OpenVPN: use an OpenVPN library and pass configuration.
        statusText.text = "START requested — implement backend integration here."
    }

    private fun stopVpn() {
        // TODO: Stop the VPN tunnel using your chosen backend's API.
        statusText.text = "STOP requested — implement backend integration here."
    }
}
