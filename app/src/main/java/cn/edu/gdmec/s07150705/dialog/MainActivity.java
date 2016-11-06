package cn.edu.gdmec.s07150705.dialog;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
    }
    public void numberShow(View v){
        final String op = "123483";
        CharacterPickerDialog cpd = new CharacterPickerDialog(this,new View(this),null,op,false){
            @Override
            public void onClick(View v) {
                et1.append(((Button)v).getText().toString());
                if(((Button)v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
    public void dateShow(View v){
        DatePickerDialog dpd = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                et2.setText("日期："+year+"-"+month+"-"+dayOfMonth);
            }
        },2016,10,25);
        dpd.show();
    }
    public void datetimeShow (View v){
        TimePickerDialog tpd = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                et3.setText(hourOfDay+":"+minute);
            }
        },9,21,true);
        tpd.show();
    }
    public void loadingShow(View v){
        final ProgressDialog pg = ProgressDialog.show(this,"加载","加载中,请销后....",true);
        new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    pg.dismiss();
                }
            }
        }.start();
    }
}
