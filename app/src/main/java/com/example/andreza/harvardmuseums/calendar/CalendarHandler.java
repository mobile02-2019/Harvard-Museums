package com.example.andreza.harvardmuseums.calendar;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;

import java.util.Calendar;
import java.util.Date;

public class CalendarHandler {
    // TODO: Receber os dados para envio ao calendário
    // TODO: Criar datas a partir de dados de dia, mês e ano
    // TODO: Executar intent para mover o usuário para o google calendar

    private Context context;
    private String title;
    private String description;
    private String eventLocation;
    private String emails;

    public CalendarHandler(Context context, String title, String description) {
        this.context = context;
        this.title = title;
        this.description = description;
        this.eventLocation = eventLocation;
    }

    public Date generateDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public void execute() {
//        Date startDate = generateDate(2018, 11, 6, 1, 0, 0);
//        Date endDate = generateDate(2018, 11, 6, 2, 0, 0);
//        String emails = "andreza@example.com,rafagan@example.com";
//        String eventLocation = "Harvard";


        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");

        intent.putExtra(CalendarContract.Events.TITLE, this.title);
        intent.putExtra(CalendarContract.Events.ALL_DAY, false);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, this.description);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, eventLocation);
//        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startDate.getTime());
//        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endDate.getTime());
        intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        intent.putExtra(Intent.EXTRA_EMAIL, emails);

        context.startActivity(intent);
    }
}
