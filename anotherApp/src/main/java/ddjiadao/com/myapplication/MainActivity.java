package ddjiadao.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view){
        Intent  intent=new Intent();
        intent.setComponent(new ComponentName("ddjiadao.com.startservicefromantherapp","ddjiadao.com.startservicefromantherapp.AppService"));
        startService(intent);

    }

    public void stopService(View view){
        Intent  intent=new Intent();
        intent.setComponent(new ComponentName("ddjiadao.com.startservicefromantherapp","ddjiadao.com.startservicefromantherapp.AppService"));
        stopService(intent);
    }

    public void bindOutService(View view){
        Intent  intent=new Intent();
        intent.setComponent(new ComponentName("ddjiadao.com.startservicefromantherapp","ddjiadao.com.startservicefromantherapp.AppService"));
        bindService(intent,this, Context.BIND_AUTO_CREATE);
    }
    public void unbindOutService(View view){
        unbindService(this);
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("msg","anotherApp---->"+"onServiceConnected");
        Log.e("msg",service.toString());

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.e("msg","anotherApp---->"+"onServiceDisconnected--->"+name);
    }
}
