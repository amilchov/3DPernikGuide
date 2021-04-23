package com.am.a3dpernikguide.util.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import android.widget.Toast;

import com.am.a3dpernikguide.model.api.sights.fortress.BarChatDataFortress;
import com.am.a3dpernikguide.model.api.sights.museum.BarChartDataMuseum;
import com.budiyev.android.codescanner.CodeScanner;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 *
 * class with different componnets
 */
public class ComponentUtils {

    //method for toast
    public static void showToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    //method for AlertDialog
    public static AlertDialog showAlertDialog(Context context, String title, String message, String buttonText) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(buttonText, (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    //method for AlertDialogError on scanner activity
    public static AlertDialog showAlertDialogScannerError(Context context, String title, String message, String buttonText, CodeScanner scanner) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(buttonText, (dialog, which) -> {
                    dialog.dismiss();
                    scanner.startPreview();
                })
                .show();
    }

    public static String getTimeAndDateNow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Timestamp(new Date().getTime()));
    }

    public static String getTimeNow() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new java.sql.Timestamp(new Date().getTime()));
    }

    public static String getTimeTomorrow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Timestamp(new Date().getTime() + 86400000));
    }

    /**
     * method which create the bar chart
     * @param barChart
     * @param dataFortress
     * @param dataMuseum
     */
    public static void createChart(BarChart barChart, List<BarChatDataFortress> dataFortress, List<BarChartDataMuseum> dataMuseum) {
        List<String> countVisit = new ArrayList<>();
        List<String> lastVisit = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<BarEntry> barEntries = new ArrayList<>();
        if (dataMuseum == null) {
            for (int i=0; i<dataFortress.size(); i++) {
                names.add(dataFortress.get(i).getFirstName() + " " + dataFortress.get(i).getLastName());
                countVisit.add(dataFortress.get(i).getCountFortress());
                lastVisit.add(dataFortress.get(i).getLastVisitFortress());
                barEntries.add(new BarEntry(i, Integer.parseInt(countVisit.get(i))));
            }
        } else if (dataFortress == null){
            for (int i=0; i<dataMuseum.size(); i++) {
                names.add(dataMuseum.get(i).getFirstName() + " " + dataMuseum.get(i).getLastName());
                countVisit.add(dataMuseum.get(i).getCountMuseum());
                lastVisit.add(dataMuseum.get(i).getLastVisitMuseum());

                barEntries.add(new BarEntry(i, Integer.parseInt(countVisit.get(i))));
            }
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Потребители с най-много посещения");
        BarData barData = new BarData(barDataSet);
        barDataSet.setColors(Color.parseColor("#B8611F"));
        barDataSet.setValueTextSize(10);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(barEntries.size());
        xAxis.setValueFormatter(new IndexAxisValueFormatter(names));
        //set angle rotation of X axis
        xAxis.setLabelRotationAngle(-13);
        barChart.getDescription().setEnabled(false);
        barChart.getViewPortHandler().setMaximumScaleX(20f);
        barChart.setData(barData);
        barChart.setFitBars(false);
        barChart.setScaleYEnabled(false);
        barChart.animateXY(1000, 1000);
        barChart.invalidate();

    }

    public static String imageToBase64(int image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(), image);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private Bitmap decodeFromBase64ToBitmap(String encodedImage) {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
}
