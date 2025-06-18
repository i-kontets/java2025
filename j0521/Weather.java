package j0521;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Weather {
    public static void main(String[] args) {
        //清風の緯度経度を設定している
        double lat=34.63672099466457;//緯度
        double lng=135.5099929153435;//経度

        //APIを使うためのプログラムを作成
        
        //アクセス先のURLを作る
        String apiurl=String.format(
            "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current=temperature_2m,wind_speed_10m,is_day,weather_code&timezone=Asia/Tokyo",
        lat,lng);
        // System.out.println(apiurl);

        
        try {
            //APIリクエストを送る処理を作る
            //JAVAの中でのURLオブジェクトを作成する
            URL url=new URL(apiurl);
            //javaの中からHTTPにアクセスする
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            //GETでアクセスする処理を実行
            conn.setRequestMethod("GET");

            //レスポンスデータを取得
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder=new StringBuilder();//最終的に画面に出したいデータがたまっていく変数
            String line;//readerから一行ずつデータをとってくるための仮変数
            //reader変数の中身を一行ずつとってきて、responseBuilderに追加していく
            while((line=reader.readLine())!=null) {
                //responseBuilderに一行ずつ追加していく
                responseBuilder.append(line);
            }
            reader.close();//readerを閉じる
            System.out.println(responseBuilder);//最終的にたまったデータを画面に出す

            //JSONに変換
            JSONObject json=new JSONObject(responseBuilder.toString());
            //jsonデータからcurrentを取得
            JSONObject current=json.getJSONObject("current");
            System.out.println(current.toString(4));//currentの中身を画面に出す

            //天気コードを日本語に変換
            String weatherDes=translateWeatherCode(current.getInt("weather_code"));
            System.out.println("天気は："+weatherDes);

            //気温を取得
            double temperature=current.getDouble("temperature_2m");
            System.out.println("気温は："+temperature+"℃");
            //風速を取得
            double windSpeed=current.getDouble("wind_speed_10m");
            System.out.println("風速は："+windSpeed+"m/s");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    // Open-Meteoのweather_codeを日本語に翻訳
    public static String translateWeatherCode(int code) {
        switch (code) {
            case 0:
                return "快晴";
            case 1:
            case 2:
            case 3:
                return "晴れ・曇り";
            case 45:
            case 48:
                return "霧";
            case 51:
            case 53:
            case 55:
                return "霧雨";
            case 61:
            case 63:
            case 65:
                return "雨";
            case 71:
            case 73:
            case 75:
                return "雪";
            case 95:
                return "雷雨";
            case 96:
            case 99:
                return "雷雨（ひょう）";
            default:
                return "不明な天気";
        }
    }
}
