package Enlistar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login.R;

import java.util.ArrayList;

import Adogtap.Animal;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList listItems;

    public Adaptador(Context context, ArrayList listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal a = (Animal)getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        ImageView imgFoto = convertView.findViewById(R.id.imgFoto);
        TextView tvTitulo = convertView.findViewById(R.id.tvTitulo);
        TextView tvContenido = convertView.findViewById(R.id.tvContenido);

        imgFoto.setImageResource(a.getImgFoto());
        tvTitulo.setText(a.getRaza());
        tvContenido.setText(a.getTipo());

        return convertView;
    }
}
