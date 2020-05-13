package com.dev.bodyfatcalculator.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dev.bodyfatcalculator.model.LocalDb;
import com.dev.bodyfatcalculator.model.Profile;
import com.dev.bodyfatcalculator.model.ProfileDao;

import java.util.ArrayList;
import java.util.List;

public class CalculatorViewModel extends AndroidViewModel {

    private ProfileDao dao;
    private LiveData<List<Profile>> list;

    public CalculatorViewModel(@NonNull Application application) {
        super(application);

        dao = LocalDb.getInstance(application).profileDao();
        list = dao.selectAll();
    }


    public void add(Profile profile) {
        new InsertAsyncTask(dao).execute(profile);
    }

    public LiveData<List<Profile>> getList() {
        return list;
    }

    static class InsertAsyncTask extends AsyncTask<Profile, Void, Void> {

        private ProfileDao dao;

        InsertAsyncTask(ProfileDao dao) {
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(Profile... profiles) {

            dao.insert(profiles[0]);
            return null;
        }
    }
}
