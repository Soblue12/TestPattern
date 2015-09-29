package com.egco.project.testpattern;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void mpWait(MediaPlayer mediaPlayer)
    {
// Wait for audio completion
        while(mediaPlayer.isPlaying())
        {
        }
    }
    public void mySound(View view)
    {

        String item = new String("โทรทัศน์");
        String rItem = readItem(item);

        String distance = "11,5,2";
        String disArray[] = distance.split("\\,");

        String pattern = "1,3,2";
        String patArray[] = pattern.split("\\,");

        String sentence = itemVoice(rItem, patArray, disArray);
        String patSen[] = sentence.split("\\,");

        //Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + "raw" + "/" + patSen[0]);


        final Button button = (Button) findViewById(R.id.button);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName() + "/" +
                "raw" + "/" + patSen[0]));
        //MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.voice_th_001);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast toast = Toast.makeText(getApplicationContext(), "Finished", Toast.LENGTH_SHORT);
                toast.show();
                mp.stop();
                mp.release();
            }
        });
        mediaPlayer.start();

        for (int i=1 ; i<patSen.length ; i++) {
            mpWait(mediaPlayer);
            //mediaPlayer = MediaPlayer.create(this, R.raw.voice_th_002);
            mediaPlayer = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName() + "/" +
                "raw" + "/" + patSen[i]));
            mediaPlayer.start();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }







    public static String randomWord(String[] word) {
        int rand = (int)(Math.random() * word.length);
        return word[rand];
    }

    public static String readItem(String item) {
        String ans = null;
        switch(item) {
            case "โทรทัศน์" :
                ans = "voice_th_046";
                break;
            case "ตู้" :
                ans = "voice_th_047";
                break;
            case "ตู้เสื้อผ้า" :
                ans = "voice_th_048";
                break;
            case "ประตูห้องน้ำ" :
                ans = "voice_th_049";
                break;
            case "สวิซต์ไฟ" :
                ans = "voice_th_050";
                break;
            case "ปลั๊กไฟ" :
                ans = "voice_th_051";
                break;
            case "สวิซต์เครื่องปรับอากาศ" :
                ans = "voice_th_052";
                break;
            case "เตียง" :
                ans = "voice_th_053";
                break;
            case "โคมไฟ" :
                ans = "voice_th_054";
                break;
            case "โต๊ะ" :
                ans = "voice_th_055";
                break;
            case "โซฟา" :
                ans = "voice_th_056";
                break;
            case "ประตูห้องนอน" :
                ans = "voice_th_058";
                break;
            case "เครื่องฉายโปรเจคเตอร์" :
                ans = "voice_th_059";
                break;
            case "หน้าจอโปรเจคเตอร์" :
                ans = "voice_th_060";
                break;
            case "โต๊ะอาจารย์" :
                ans = "voice_th_061";
                break;
            case "โต๊ะเรียน" :
                ans = "voice_th_062";
                break;
            case "โต๊ะผู้บรรยาย" :
                ans = "voice_th_063";
                break;
            case "โต๊ะฟังบรรยาย" :
                ans = "voice_th_064";
                break;
            default :
                break;
        }

        return ans;
    }

    public static String readDistance(int distance) {
        int ten = distance/10;
        int tenMod = ten%10;
        int digit = distance%10;
        String ans = null;

        if (ten > 0) {
            switch(tenMod) {
                case 1 :
                    ans = "voice_th_010";
                    break;
                case 2 :
                    ans = "voice_th_013";
                    break;
                case 3 :
                    ans = "voice_th_003,voice_th_010";
                    break;
                case 4 :
                    ans = "voice_th_004,voice_th_010";
                    break;
                case 5 :
                    ans = "voice_th_005,voice_th_010";
                    break;
                case 6 :
                    ans = "voice_th_006,voice_th_010";
                    break;
                case 7 :
                    ans = "voice_th_007,voice_th_010";
                    break;
                case 8 :
                    ans = "voice_th_008,voice_th_010";
                    break;
                case 9 :
                    ans = "voice_th_009,voice_th_010";
                    break;
                default :
                    break;
            }
            switch(digit) {
                case 1 :
                    ans = ans + ",voice_th_012";
                    break;
                case 2 :
                    ans = ans + ",voice_th_002";
                    break;
                case 3 :
                    ans = ans + ",voice_th_003";
                    break;
                case 4 :
                    ans = ans + ",voice_th_004";
                    break;
                case 5 :
                    ans = ans + ",voice_th_005";
                    break;
                case 6 :
                    ans = ans + ",voice_th_006";
                    break;
                case 7 :
                    ans = ans + ",voice_th_007";
                    break;
                case 8 :
                    ans = ans + ",voice_th_008";
                    break;
                case 9 :
                    ans = ans + ",voice_th_009";
                    break;
                default :
                    break;
            }
        }
        else {
            switch(digit) {
                case 1 :
                    ans = "voice_th_001";
                    break;
                case 2 :
                    ans = "voice_th_002";
                    break;
                case 3 :
                    ans = "voice_th_003";
                    break;
                case 4 :
                    ans = "voice_th_004";
                    break;
                case 5 :
                    ans = "voice_th_005";
                    break;
                case 6 :
                    ans = "voice_th_006";
                    break;
                case 7 :
                    ans = "voice_th_007";
                    break;
                case 8 :
                    ans = "voice_th_008";
                    break;
                case 9 :
                    ans = "voice_th_009";
                    break;
                default :
                    break;
            }
        }

        return ans;
    }

    public static String itemVoice(String itemName, String[] pattern, String[] distance) {
        int disCount = 0;
        String sentence = null;
        Boolean zone = false;
        int i = 0;
        if (Integer.parseInt(pattern[0]) == 0) {
            sentence = "โซน";
            i++;
            disCount++;
            zone = true;
        }

        for ( ; i<pattern.length ; i++) {
            int countSwitch = Integer.parseInt(pattern[i]) ;
            int dis = Integer.parseInt(distance[disCount]);
            String sendDis = readDistance(dis);

            switch(countSwitch) {
                case 1 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternFront(sendDis);
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternFront(sendDis);
                    }
                    else {
                        sentence = sentence + "," + patternFront(sendDis);
                    }
                    disCount++;
                    break;
                case 2 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternWallHeight(sendDis);
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternWallHeight(sendDis);
                    }
                    else {
                        sentence = sentence + "," + patternWallHeight(sendDis);
                    }
                    disCount++;
                    break;
                case 3 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternTurnLeft(sendDis);
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternTurnLeft(sendDis);
                    }
                    else {
                        sentence = sentence + "," + patternTurnLeft(sendDis);
                    }
                    disCount++;
                    break;
                case 4 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternTurnRight(sendDis);
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternTurnRight(sendDis);
                    }
                    else {
                        sentence = sentence + "," + patternTurnRight(sendDis);
                    }
                    disCount++;
                    break;
                case 5 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternHeight(sendDis);
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternHeight(sendDis);
                    }
                    else {
                        sentence = sentence + "," + patternHeight(sendDis);
                    }
                    disCount++;
                    break;
                case 6 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternLeft();
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternLeft();
                    }
                    else {
                        sentence = sentence + "," + patternLeft();
                    }
                    disCount++;
                    break;
                case 7 :
                    if (zone == true && i == 1) {
                        sentence = sentence + "," + itemName + "," + patternRight();
                    }
                    else if (zone == false && i == 0) {
                        sentence = itemName + "," + patternRight();
                    }
                    else {
                        sentence = sentence + "," + patternRight();
                    }
                    disCount++;
                    break;
                default :
                    break;
            }
        }

        return sentence;
    }

    public static String patternFront(String distance) {
        String[] wordFront = new String[]{"voice_th_019", "voice_th_020", "voice_th_021"};
        String word;
        String part1 = "voice_th_041";

        word = randomWord(wordFront);

        String ans = word + "," + distance + "," + part1;

        return ans;
    }

    public static String patternWallHeight(String distance) {
        String[] wordWallHeight = new String[]{"voice_th_026", "voice_th_027"};
        String word;
        String part1 = "voice_th_042,voice_th_043";

        word = randomWord(wordWallHeight);

        String ans = part1 + "," + word + "," + distance;

        return ans;
    }

    public static String patternTurnLeft(String distance) {
        String[] wordTurnLeft = new String[]{"voice_th_022,voice_th_035", "voice_th_023,voice_th_035", "voice_th_024,voice_th_035", "voice_th_025,voice_th_035"};
        String word;
        String part1 = "voice_th_044";
        String part2 = "voice_th_045";
        String part3 = "voice_th_041";

        word = randomWord(wordTurnLeft);

        String ans = part1 + "," + word + "," + part2 + "," + distance + "," + part3;

        return ans;
    }

    public static String patternTurnRight(String distance) {
        String[] wordTurnRight = new String[]{"voice_th_022,voice_th_036", "voice_th_023,voice_th_036", "voice_th_024,voice_th_036", "voice_th_025,voice_th_036"};
        String word;
        String part1 = "voice_th_044";
        String part2 = "voice_th_045";
        String part3 = "voice_th_041";

        word = randomWord(wordTurnRight);

        String ans = part1 + "," + word + "," + part2 + "," + distance + "," + part3;

        return ans;
    }

    public static String patternHeight(String distance) {
        String[] wordHeight = new String[]{"voice_th_026", "voice_th_027"};
        String word;
        String part1 = "อยู่ที่ความสูง";

        word = randomWord(wordHeight);

        String ans = part1 + word + " " + distance;

        return ans;
    }

    public static String patternLeft() {
        String[] wordLeft = new String[]{"อยู่ทางซ้าย", "อยู่ทางซ้ายมือ", "อยู่ทางด้านซ้าย", "อยู่ทางด้านซ้ายมือ"};
        String word;

        word = randomWord(wordLeft);

        return word;
    }

    public static String patternRight() {
        String[] wordRight = new String[]{"อยู่ทางขวา", "อยู่ทางขวามือ", "อยู่ทางด้านขวา", "อยู่ทางด้านขวามือ"};
        String word;

        word = randomWord(wordRight);

        return word;
    }
}
