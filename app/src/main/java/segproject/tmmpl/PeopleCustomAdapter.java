package segproject.tmmpl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by trist on 2017-11-22.
 */

public class PeopleCustomAdapter extends ArrayAdapter {
    private final Context context;
    private final String[] myUsers;
    private final int[] avatars;
    private final String[] completed;
    private final String[] nextTasks;

    public PeopleCustomAdapter(Context context, String[] userList, int[] avatarList, String[] completedList, String[] nextTaskList) {
        super(context, R.layout.people_task_layout, userList);
        this.context = context;
        this.myUsers = userList;
        this.avatars = avatarList;
        this.completed = completedList;
        this.nextTasks = nextTaskList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.people_task_layout, parent, false);

        TextView userNameTextField = (TextView) rowView.findViewById(R.id.userName);
        TextView taskCountTextField = (TextView) rowView.findViewById(R.id.taskCount);
        TextView nextTaskTextField = (TextView) rowView.findViewById(R.id.nextTask);
        ImageView userImage = (ImageView) rowView.findViewById(R.id.icon);

        userNameTextField.setText(myUsers[position]);
        taskCountTextField.setText("Allocated Tasks: " + completed[position]);
        userImage.setImageResource(avatars[position]);
        nextTaskTextField.setText("Next Task: " + nextTasks[position]);


        return rowView;
    }
}