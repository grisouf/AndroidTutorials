package com.dev.bodyfatcalculator.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.dev.bodyfatcalculator.model.LocalDb;
import com.dev.bodyfatcalculator.model.Profile;
import com.dev.bodyfatcalculator.model.ProfileDao;

public class CalculatorViewModel extends AndroidViewModel {

    private ProfileDao dao;

    public CalculatorViewModel(@NonNull Application application) {
        super(application);

        dao = LocalDb.getInstance(application).profileDao();
    }


    public void add(Profile profile) {
        new InsertAsyncTask(dao).execute(profile);
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
