package com.example.cmpt276group05.utils;

import android.content.Context;
import android.text.TextUtils;

import com.example.cmpt276group05.R;
import com.example.cmpt276group05.model.BaseEntity;
import com.example.cmpt276group05.model.InspectionEntity;
import com.example.cmpt276group05.model.RestaurantEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FileUtils {
    public static List<BaseEntity> readDataFromCsvFile(Context context, int fileId){
        List<BaseEntity> dataList = new ArrayList<>();
        // Read the raw csv file
        InputStream is =  context.getApplicationContext().getResources().openRawResource(fileId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";
        // Handling exceptions
        try {

            boolean firstLineFlag = true;
            while ((line = br.readLine()) != null) {
                // use comma as separator columns of CSV
                if(firstLineFlag){
                    firstLineFlag = !firstLineFlag;
                }else{
                    String[] cols = line.split(",");
                    if(fileId == R.raw.restaurants){
                        RestaurantEntity re = new RestaurantEntity();
                        re.setCode(eraseQuotation(cols[0]));
                        re.setName(eraseQuotation(cols[1]));
                        re.setAddress(eraseQuotation(cols[2]));
                        re.setCity(eraseQuotation(cols[3]));
                        re.setType(eraseQuotation(cols[4]));
                        re.setLatitude(eraseQuotation(cols[5]));
                        re.setLongitude(eraseQuotation(cols[6]));
                        dataList.add(re);
                    }else if(fileId == R.raw.inspectionreports){
                        InspectionEntity inspection = new InspectionEntity();
                        inspection.setCode(eraseQuotation(cols[0]));
                        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
                        Date date =sdf.parse(cols[1]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        inspection.setInspectionDate(calendar.getTime());
                        inspection.setInspectionType(eraseQuotation(cols[2]));
                        inspection.setNumCritical(Integer.parseInt(cols[3]));
                        inspection.setNumNoCritical(Integer.parseInt(cols[4]));
                        inspection.setHazardRating(eraseQuotation(cols[5]));
                        if(cols.length>6){
                            StringBuffer result = new StringBuffer();
                            for(int i=6;i<cols.length;i++){
                                result.append(cols[i]).append(",");
                            }
                            inspection.setViolLump(result.substring(1,result.toString().length()-2));
                        }
                        dataList.add(inspection);
                    }

                }
            }
        } catch (Exception e) {
            // Prints throwable details
            e.printStackTrace();
        }

        return dataList;
    }

    private static String eraseQuotation(String str){
        if(TextUtils.isEmpty(str)){
            return str;
        }
        return str.substring(1,str.length()-1);
    }

}
