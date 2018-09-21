package nerallan.com.chat.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nerallan.com.chat.Model.ChatModel;
import nerallan.com.chat.R;
import nerallan.com.chat.ViewHolder;

/**
 * Created by Nerallan on 6/16/2018.
 *
 * adapter gets item view from ViewHolder
 */

public class DataAdapter extends RecyclerView.Adapter<ViewHolder>{

    ArrayList<String> messages;
    // generate from xml file view element
    LayoutInflater inflater;


    private List<ChatModel> chatModels;


    // context get ability to mainActivity to use inflater
    // inflater generate object
    public DataAdapter(Context context, ArrayList<String> messages) {
        this.messages = messages;
        this.inflater = LayoutInflater.from(context);
    }

    // return generated view from ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_message, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        ChatModel chatModel = chatModels.get(position);
//        holder.message.setText(chatModel.getMessageText());
//        holder.user.setText(chatModel.getMessageText());
        String msg = messages.get(position);
        // set message to viewholder textvview;
        holder.message.setText(msg);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}