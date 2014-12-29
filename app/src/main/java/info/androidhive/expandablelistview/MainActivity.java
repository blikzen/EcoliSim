package info.androidhive.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
    final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub

                switch(groupPosition){
                    case 0:
                        switch(childPosition){
                            case 0:
                                LayoutInflater inflater = getLayoutInflater();
                                View dialoglayout = inflater.inflate(R.layout.numcell, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change number of cells")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        // if this button is clicked, close
                                                        // current activity
                                                        MainActivity.this.finish();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        // if this button is clicked, just close
                                                        // the dialog box and do nothing
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.setView(dialoglayout);
                                builder.show();
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        break;
                    case 1:
                        switch(childPosition) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 2:
                        switch(childPosition) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                        }
                        break;
                    case 3:
                        switch(childPosition) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                        }
                        break;
                    case 4:
                        switch(childPosition) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                        }
                        break;
                    case 5:
                        switch(childPosition) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                        break;
                }
                /*Toast.makeText(
						getApplicationContext(),
						groupPosition + " " + childPosition
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();*/
				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Basics");
		listDataHeader.add("Matrix");
		listDataHeader.add("Gradient");
        listDataHeader.add("Motility");
        listDataHeader.add("Network");
        listDataHeader.add("Algorithm");

		// Adding child data
		List<String> basiclist = new ArrayList<String>();
		basiclist.add("Number of cells");
        basiclist.add("Time of simulation");
        basiclist.add("Random seed numbers");
        basiclist.add("Output file - averages");
        basiclist.add("Output file - full dataset");

		List<String> matrixlist = new ArrayList<String>();
        matrixlist.add("Matrix size");
        matrixlist.add("Starting position");
        matrixlist.add("Starting orientation");

		List<String> gradientlist = new ArrayList<String>();
        gradientlist.add("No gradient (default)");
        gradientlist.add("Constant activity C(x,y)");
        gradientlist.add("Constant activity C(x)");
        gradientlist.add("Constant activity C(t)");
        gradientlist.add("Linear f(x)");
        gradientlist.add("Gaussian G(x,y)");
        gradientlist.add("Gaussian G(x)");
        gradientlist.add("Exponential E(t)");
        gradientlist.add("Exponential E(x)");
        gradientlist.add("Stepwise");

        List<String> motlist = new ArrayList<String>();
        motlist.add("Number of motors");
        motlist.add("Rotary diffusion");
        motlist.add("Speed");
        motlist.add("Resting motor bias");
        motlist.add("Medium");
        motlist.add("Boundary");

        List<String> networklist = new ArrayList<String>();
        networklist.add("CheA");
        networklist.add("CheB");
        networklist.add("CheR");
        networklist.add("CheY");
        networklist.add("CheZ");
        networklist.add("TAR - receptor ligand KD-S");
        networklist.add("TSR - receptor ligand KD-S");
        networklist.add("Cluster composition");

        List<String> algolist = new ArrayList<String>();
        algolist.add("Integration dt");
        algolist.add("Tumble");
        algolist.add("Run");
        algolist.add("Motor");

        listDataChild.put(listDataHeader.get(0), basiclist); // Header, Child data
		listDataChild.put(listDataHeader.get(1), matrixlist);
		listDataChild.put(listDataHeader.get(2), gradientlist);
        listDataChild.put(listDataHeader.get(3), motlist);
        listDataChild.put(listDataHeader.get(4), networklist);
        listDataChild.put(listDataHeader.get(5), algolist);
	}
}
