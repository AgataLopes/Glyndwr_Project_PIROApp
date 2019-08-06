import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImgAdapter extends BaseAdapter {

    private Context context;

    public Integer[] imgs = {
            R.drawable.mot_1, R.drawable.mot_2, R.drawable.mot_3, R.drawable.mot_4, R.drawable.mot_5,
            R.drawable.mot_6, R.drawable.mot_7, R.drawable.mot_8, R.drawable.mot_9, R.drawable.mot_10,
            R.drawable.mot_11, R.drawable.mot_12, R.drawable.mot_13, R.drawable.mot_14, R.drawable.mot_15,
            R.drawable.mot_16, R.drawable.mot_17, R.drawable.mot_18, R.drawable.mot_19, R.drawable.mot_20,
    };

    public ImgAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imgs[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(800,800));
        return imageView;
    }
}

