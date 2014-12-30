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
                                final View dialoglayout = inflater.inflate(R.layout.numcell, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout);
                                EditText numcell_et = (EditText) dialoglayout.findViewById(R.id.numcell_id);
                                numcell_et.setText(String.valueOf(modelvars.n_cells));
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change number of cells")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText numcell_et = (EditText) dialoglayout.findViewById(R.id.numcell_id);
                                                        modelvars.n_cells = Integer.parseInt(numcell_et.getText().toString());
                                                        dialog.cancel();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.show();
                                break;
                            case 1:
                                inflater = getLayoutInflater();
                                final View dialoglayout_timesim = inflater.inflate(R.layout.timesim, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_timesim);
                                EditText timesim_et = (EditText) dialoglayout_timesim.findViewById(R.id.timesim_id);
                                timesim_et.setText(String.valueOf(modelvars.time_sim));
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change time of simulation (s)")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText timesim_et = (EditText) dialoglayout_timesim.findViewById(R.id.timesim_id);
                                                        modelvars.time_sim = Double.parseDouble(timesim_et.getText().toString());
                                                        dialog.cancel();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.show();
                                break;
                            case 2:
                                inflater = getLayoutInflater();
                                final View dialoglayout_seed = inflater.inflate(R.layout.seednum, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_seed);
                                EditText seednum_et = (EditText) dialoglayout_seed.findViewById(R.id.seednum_id);
                                seednum_et.setText(String.valueOf(modelvars.rand_seed));
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change random seed number")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText seednum_et = (EditText) dialoglayout_seed.findViewById(R.id.seednum_id);
                                                        modelvars.rand_seed = Integer.parseInt(seednum_et.getText().toString());
                                                        dialog.cancel();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.show();
                                break;
                            case 3:
                                inflater = getLayoutInflater();
                                final View dialoglayout_outavg = inflater.inflate(R.layout.outavg, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_outavg);
                                EditText outavg_et = (EditText) dialoglayout_outavg.findViewById(R.id.outavg_id);
                                outavg_et.setText(String.valueOf(modelvars.avgname));
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change averages output file name")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText outavg_et = (EditText) dialoglayout_outavg.findViewById(R.id.outavg_id);
                                                        modelvars.avgname = outavg_et.getText().toString();
                                                        dialog.cancel();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.show();
                                break;
                            case 4:
                                inflater = getLayoutInflater();
                                final View dialoglayout_outfull = inflater.inflate(R.layout.outfull, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_outfull);
                                EditText outfull_et = (EditText) dialoglayout_outfull.findViewById(R.id.outfull_id);
                                outfull_et.setText(String.valueOf(modelvars.fullname));
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change full dataset output file name")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText outfull_et = (EditText) dialoglayout_outfull.findViewById(R.id.outfull_id);
                                                        modelvars.avgname = outfull_et.getText().toString();
                                                        dialog.cancel();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.show();
                                break;
                        }
                        break;
                    case 1:
                        switch(childPosition) {
                            case 0:
                                LayoutInflater inflater = getLayoutInflater();
                                final View dialoglayout_matrixsize = inflater.inflate(R.layout.matrixsize, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_matrixsize);
                                EditText mxsize_et = (EditText) dialoglayout_matrixsize.findViewById(R.id.mxsize_id);
                                EditText mysize_et = (EditText) dialoglayout_matrixsize.findViewById(R.id.mysize_id);
                                mxsize_et.setText(String.valueOf(modelvars.matrix_x));
                                mysize_et.setText(String.valueOf(modelvars.matrix_y));
                                builder.setTitle("Edit");
                                // set dialog message
                                builder
                                        .setMessage("Change size of matrix")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText mxsize_et = (EditText) dialoglayout_matrixsize.findViewById(R.id.mxsize_id);
                                                        modelvars.matrix_x = Double.parseDouble(mxsize_et.getText().toString());
                                                        EditText mysize_et = (EditText) dialoglayout_matrixsize.findViewById(R.id.mysize_id);
                                                        modelvars.matrix_y = Double.parseDouble(mysize_et.getText().toString());
                                                        dialog.cancel();
                                                    }
                                                })
                                        .setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        dialog.cancel();
                                                    }
                                                });
                                builder.show();
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
        basiclist.add("Random seed number");
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
