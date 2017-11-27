package segproject.tmmpl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter<User> {

    private Activity context;
    List<User> users;

    int[] images = {
            R.mipmap.i1,
            R.mipmap.i2,
            R.mipmap.i6,
            R.mipmap.i3,
            R.mipmap.i4,
            R.mipmap.i5,
            };

    public UserList(Activity context, List<User> users) {
        super(context, R.layout.layout_user_list, users);
        this.context = context;
        this.users = users;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_user_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewUsername);
//        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);

        User user = users.get(position);
        textViewName.setText(user.getUsername());
        ImageView avatar = (ImageView) listViewItem.findViewById(R.id.userAvatar);
        avatar.setImageResource(images[position% images.length]);
//        textViewPrice.setText(String.valueOf(product.getPrice()));
        return listViewItem;
    }
}
