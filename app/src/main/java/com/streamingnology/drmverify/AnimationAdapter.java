package com.streamingnology.drmverify;

import android.media.MediaDrm;
import android.os.Build;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimationAdapter extends BaseQuickAdapter<DeviceInfo, BaseViewHolder> {
    /**
     * UUID for the W3C
     * <a href="https://w3c.github.io/encrypted-media/format-registry/initdata/cenc.html">Common PSSH
     * box</a>.
     */
    public static final UUID COMMON_PSSH_UUID = new UUID(0x1077EFECC0B24D02L, 0xACE33C1E52E2FB4BL);

    /**
     * UUID for the ClearKey DRM scheme.
     * <p>
     * ClearKey is supported on Android devices running Android 5.0 (API Level 21) and up.
     */
    public static final UUID CLEARKEY_UUID = new UUID(0xE2719D58A985B3C9L, 0x781AB030AF78D30EL);

    /**
     * UUID for the Widevine DRM scheme.
     * <p>
     * Widevine is supported on Android devices running Android 4.3 (API Level 18) and up.
     */
    public static final UUID WIDEVINE_UUID = new UUID(0xEDEF8BA979D64ACEL, 0xA3C827DCD51D21EDL);

    /**
     * UUID for the PlayReady DRM scheme.
     * <p>
     * PlayReady is supported on all AndroidTV devices. Note that most other Android devices do not
     * provide PlayReady support.
     */
    public static final UUID PLAYREADY_UUID = new UUID(0x9A04F07998404286L, 0xAB92E65BE0885F95L);

    public AnimationAdapter() {
        super(R.layout.layout_drminfo_cardview, getSampleData(3));
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DeviceInfo item) {
        helper.addOnClickListener(R.id.totestpage);
        if (item == null) {
            return;
        }
        if (item.ishardwareinfo) {
            helper.setText(R.id.description, item.description);
            helper.setText(R.id.brand_value, item.brand);
            helper.setText(R.id.hardware_value, item.hardware);
            helper.setText(R.id.sdklevel_value, item.sdklevel);
            helper.setGone(R.id.totestpage, false);

            helper.setGone(R.id.vendor, !item.vendor.isEmpty());
            helper.setGone(R.id.vendor_value, !item.vendor.isEmpty());
            helper.setGone(R.id.version, !item.version.isEmpty());
            helper.setGone(R.id.version_value, !item.version.isEmpty());
            helper.setGone(R.id.description, !item.description.isEmpty());
            helper.setGone(R.id.algorithms, !item.algorithms.isEmpty());
            helper.setGone(R.id.algorithms_value, !item.algorithms.isEmpty());
            helper.setGone(R.id.securityLevel, !item.securitylevel.isEmpty());
            helper.setGone(R.id.securityLevel_value, !item.securitylevel.isEmpty());
            helper.setGone(R.id.systemId, !item.systemid.isEmpty());
            helper.setGone(R.id.systemId_value, !item.systemid.isEmpty());
            helper.setGone(R.id.hdcpLevel, !item.hdcplevel.isEmpty());
            helper.setGone(R.id.hdcpLevel_value, !item.hdcplevel.isEmpty());
            helper.setGone(R.id.maxHdcpLevel, !item.maxhdcplevel.isEmpty());
            helper.setGone(R.id.maxHdcpLevel_value, !item.maxhdcplevel.isEmpty());
            helper.setGone(R.id.usageReportingSupport, !item.usagereportingsupport.isEmpty());
            helper.setGone(R.id.usageReportingSupport_value, !item.usagereportingsupport.isEmpty());
            helper.setGone(R.id.maxNumberOfSessions, !item.maxnumberofsessions.isEmpty());
            helper.setGone(R.id.maxNumberOfSessions_value, !item.maxnumberofsessions.isEmpty());
            helper.setGone(R.id.numberOfOpenSessions, !item.numberofopensessions.isEmpty());
            helper.setGone(R.id.numberOfOpenSessions_value, !item.numberofopensessions.isEmpty());
        }
        if (item.isdrm) {
            helper.setGone(R.id.brand, false);
            helper.setGone(R.id.brand_value, false);
            helper.setGone(R.id.hardware, false);
            helper.setGone(R.id.hardware_value, false);
            helper.setGone(R.id.sdklevel, false);
            helper.setGone(R.id.sdklevel_value, false);
            helper.setText(R.id.totestpage, SpannableStringUtils.getBuilder("").append("CLICK HERE TO PLAYBACK TEST STREAMS").setClickSpan(clickableSpan).create());
            ((TextView) helper.getView(R.id.totestpage)).setMovementMethod(LinkMovementMethod.getInstance());

            helper.setText(R.id.vendor_value, item.vendor);
            helper.setGone(R.id.vendor, !item.vendor.isEmpty());
            helper.setGone(R.id.vendor_value, !item.vendor.isEmpty());
            helper.setText(R.id.version_value, item.version);
            helper.setGone(R.id.version, !item.version.isEmpty());
            helper.setGone(R.id.version_value, !item.version.isEmpty());
            helper.setText(R.id.description, item.description);
            helper.setGone(R.id.description, !item.description.isEmpty());
            helper.setText(R.id.algorithms_value, item.algorithms);
            helper.setGone(R.id.algorithms, !item.algorithms.isEmpty());
            helper.setGone(R.id.algorithms_value, !item.algorithms.isEmpty());
            helper.setText(R.id.securityLevel_value, item.securitylevel);
            helper.setGone(R.id.securityLevel, !item.securitylevel.isEmpty());
            helper.setGone(R.id.securityLevel_value, !item.securitylevel.isEmpty());
            helper.setText(R.id.systemId_value, item.systemid);
            helper.setGone(R.id.systemId, !item.systemid.isEmpty());
            helper.setGone(R.id.systemId_value, !item.systemid.isEmpty());
            helper.setText(R.id.hdcpLevel_value, item.hdcplevel);
            helper.setGone(R.id.hdcpLevel, !item.hdcplevel.isEmpty());
            helper.setGone(R.id.hdcpLevel_value, !item.hdcplevel.isEmpty());
            helper.setText(R.id.maxHdcpLevel_value, item.maxhdcplevel);
            helper.setGone(R.id.maxHdcpLevel, !item.maxhdcplevel.isEmpty());
            helper.setGone(R.id.maxHdcpLevel_value, !item.maxhdcplevel.isEmpty());
            helper.setText(R.id.usageReportingSupport_value, item.usagereportingsupport);
            helper.setGone(R.id.usageReportingSupport, !item.usagereportingsupport.isEmpty());
            helper.setGone(R.id.usageReportingSupport_value, !item.usagereportingsupport.isEmpty());
            helper.setText(R.id.maxNumberOfSessions_value, item.maxnumberofsessions);
            helper.setGone(R.id.maxNumberOfSessions, !item.maxnumberofsessions.isEmpty());
            helper.setGone(R.id.maxNumberOfSessions_value, !item.maxnumberofsessions.isEmpty());
            helper.setText(R.id.numberOfOpenSessions_value, item.numberofopensessions);
            helper.setGone(R.id.numberOfOpenSessions, !item.numberofopensessions.isEmpty());
            helper.setGone(R.id.numberOfOpenSessions_value, !item.numberofopensessions.isEmpty());
        }
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };

    static private List<DeviceInfo> getSampleData(int lenth) {
        List<DeviceInfo> list = new ArrayList<>();
        DeviceInfo hardware = gethardware();
        if (hardware != null) {
            list.add(hardware);
        }

        DeviceInfo wv = getwv();
        if (wv != null) {
            list.add(wv);
        }

        DeviceInfo pssh = getpssh();
        if (pssh != null) {
            list.add(pssh);
        }

        DeviceInfo playready = getplayready();
        if (playready != null) {
            list.add(playready);
        }

        DeviceInfo clearkey = getclearkey();
        if (clearkey != null) {
            list.add(clearkey);
        }

        return list;
    }

    static private DeviceInfo getwv() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return null;
        }
        MediaDrm mediaDrm; DeviceInfo deviceinfo = new DeviceInfo();
        boolean finddrm = false;
        try {
            mediaDrm = new MediaDrm(WIDEVINE_UUID);
            deviceinfo.vendor = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VENDOR);
            deviceinfo.version = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VERSION);
            deviceinfo.description = mediaDrm.getPropertyString(MediaDrm.PROPERTY_DESCRIPTION);
            deviceinfo.algorithms = mediaDrm.getPropertyString(MediaDrm.PROPERTY_ALGORITHMS);
            finddrm = true;
            deviceinfo.securitylevel = mediaDrm.getPropertyString("securityLevel");
            deviceinfo.systemid = mediaDrm.getPropertyString("systemId");
            deviceinfo.hdcplevel = mediaDrm.getPropertyString("hdcpLevel");
            deviceinfo.maxhdcplevel = mediaDrm.getPropertyString("maxHdcpLevel");
            deviceinfo.usagereportingsupport = mediaDrm.getPropertyString("usageReportingSupport");
            deviceinfo.maxnumberofsessions = mediaDrm.getPropertyString("maxNumberOfSessions");
            deviceinfo.numberofopensessions = mediaDrm.getPropertyString("numberOfOpenSessions");
            mediaDrm = null;
        }  catch (Exception e) {
        }
        if (finddrm) {
            deviceinfo.isdrm = true;
            return deviceinfo;
        } else {
            return null;
        }
    }

    static private DeviceInfo getpssh() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return null;
        }
        MediaDrm mediaDrm; DeviceInfo deviceinfo = new DeviceInfo();
        boolean finddrm = false;
        try {
            mediaDrm = new MediaDrm(COMMON_PSSH_UUID);
            deviceinfo.vendor = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VENDOR);
            deviceinfo.version = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VERSION);
            deviceinfo.description = mediaDrm.getPropertyString(MediaDrm.PROPERTY_DESCRIPTION);
            deviceinfo.algorithms = mediaDrm.getPropertyString(MediaDrm.PROPERTY_ALGORITHMS);
            finddrm = true;
            mediaDrm = null;
        }  catch (Exception e) {
        }
        if (finddrm) {
            deviceinfo.isdrm = true;
            return deviceinfo;
        } else {
            return null;
        }
    }

    static private DeviceInfo getplayready() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return null;
        }
        MediaDrm mediaDrm; DeviceInfo deviceinfo = new DeviceInfo();
        boolean finddrm = false;
        try {
            mediaDrm = new MediaDrm(PLAYREADY_UUID);
            deviceinfo.vendor = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VENDOR);
            deviceinfo.version = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VERSION);
            deviceinfo.description = mediaDrm.getPropertyString(MediaDrm.PROPERTY_DESCRIPTION);
            deviceinfo.algorithms = mediaDrm.getPropertyString(MediaDrm.PROPERTY_ALGORITHMS);
            finddrm = true;
            mediaDrm = null;
        }  catch (Exception e) {
        }
        if (finddrm) {
            deviceinfo.isdrm = true;
            return deviceinfo;
        } else {
            return null;
        }
    }

    static private DeviceInfo getclearkey() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return null;
        }
        MediaDrm mediaDrm; DeviceInfo deviceinfo = new DeviceInfo();
        boolean finddrm = false;
        try {
            mediaDrm = new MediaDrm(CLEARKEY_UUID);
            deviceinfo.vendor = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VENDOR);
            deviceinfo.version = mediaDrm.getPropertyString(MediaDrm.PROPERTY_VERSION);
            deviceinfo.description = mediaDrm.getPropertyString(MediaDrm.PROPERTY_DESCRIPTION);
            deviceinfo.algorithms = mediaDrm.getPropertyString(MediaDrm.PROPERTY_ALGORITHMS);
            finddrm = true;
            mediaDrm = null;
        }  catch (Exception e) {
        }
        if (finddrm) {
            deviceinfo.isdrm = true;
            return deviceinfo;
        } else {
            return null;
        }
    }

    static private DeviceInfo gethardware() {
        DeviceInfo hardware = new DeviceInfo();
        hardware.ishardwareinfo = true;
        hardware.description = Build.BRAND + " " + Build.MODEL;
        hardware.brand = Build.BRAND;
        hardware.model = Build.MODEL;
        hardware.hardware = Build.HARDWARE;
        hardware.sdklevel = String.valueOf(Build.VERSION.SDK_INT);
        return hardware;
    }

}
