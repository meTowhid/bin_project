package com.nibri.binproject.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.Toast;

public class Utils {
    public static void setHtml(TextView textView, String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(text));
        }
    }

    public static void copyCode(Context context, String code) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Coupon Code", code);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(context, code + " copied!", Toast.LENGTH_SHORT).show();
    }

    public static int dpToPixel(Context context, int dp) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        return Math.round(px);
    }
}
