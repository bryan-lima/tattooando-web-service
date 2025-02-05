package com.tattooando.project.Studio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.tattooando.project.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class HomeStudioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Context context = HomeStudioActivity.this;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        configurarNavBar();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Adicionar novo serviço", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(context, ServicoAdicionaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // // mAppBarConfiguration = new AppBarConfiguration.Builder(
                // // R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                // // R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                // // .setDrawerLayout(drawer)
                // // .build();
        // // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        // // NavigationUI.setupWithNavController(navigationView, navController);
    }

    // // @Override
    // // public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // // getMenuInflater().inflate(R.menu.home_stu, menu);
        // // return true;
    // // }

    // // @Override
    // // public boolean onSupportNavigateUp() {
        // // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        // // return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                // // || super.onSupportNavigateUp();
    // // }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void configurarNavBar() {
        setTitle("Home");
        // ActionBar actionBar = getSupportActionBar(); // Instancia objeto da BAR
    }

    private void  alertDialog(String strTitle, String strMsg){
        new AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog_Alert)
                .setTitle(strTitle)
                .setMessage(strMsg)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    } }).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            alertDialogOnBackPressed("Sair?", "Deseja sair da sua conta?");
        }
    }

    private void alertDialogOnBackPressed(String strTitle, String strMsg) {
        new AlertDialog.Builder(context, R.style.Theme_AppCompat_Dialog_Alert)
                .setTitle(strTitle)
                .setMessage(strMsg)
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // m.alertToast(context, "Nenhuma ação foi realizada.");
                    }
                })
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, LoginStudioActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home_cli, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatemen
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stu_home) {
            Intent intent = new Intent(context, HomeStudioActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_historico) {
            Intent intent = new Intent(context, HistoricoStudioActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_lst_servicos) {
            Intent intent = new Intent(context, ServicoListaActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_add_servicos) {
            Intent intent = new Intent(context, ServicoAdicionaActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_perfil) {
            Intent intent = new Intent(context, PerfilStudioActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_hor_func) {
            Intent intent = new Intent(context, HorarioFuncActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_sobre) {
            Intent intent = new Intent(context, SobreStudioActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_stu_sair) {
            Intent intent = new Intent(context, LoginStudioActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
