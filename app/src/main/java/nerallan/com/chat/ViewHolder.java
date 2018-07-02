package nerallan.com.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Nerallan on 6/14/2018.
 *
 * manages how to display 1 message in 1 item view
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView message;
    TextView time;
    // constructor of basic class
    public ViewHolder(View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.message_item);
        time = itemView.findViewById(R.id.current_time);
    }
}
