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
import java.util.Map;


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
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {

			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {


			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final Map<Integer, String> listsel = new HashMap<Integer, String>();
                listsel.put(0,"No gradient");
                listsel.put(1,"C(x,y)");
                listsel.put(2,"C(x)");
                listsel.put(3,"C(t)");
                listsel.put(4,"f(x)");
                listsel.put(5,"G(x,y)");
                listsel.put(6,"G(x)");
                listsel.put(7,"E(t)");
                listsel.put(8,"E(x)");
                listsel.put(9,"Stepwise");
                switch(groupPosition){
                    // TODO Auto-generated method stub
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
                                        .setMessage("Change size of matrix\n\tDefaults center start location on resize")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText mxsize_et = (EditText) dialoglayout_matrixsize.findViewById(R.id.mxsize_id);
                                                        EditText mysize_et = (EditText) dialoglayout_matrixsize.findViewById(R.id.mysize_id);
                                                        modelvars.matrix_x = Double.parseDouble(mxsize_et.getText().toString());
                                                        modelvars.matrix_y = Double.parseDouble(mysize_et.getText().toString());
                                                        modelvars.ini_pos_x = modelvars.matrix_x / 2;
                                                        modelvars.ini_pos_y = modelvars.matrix_y / 2;
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

                                Map<Integer, String> currentsel = new HashMap<Integer, String>();
                                    currentsel.put(0, "Center");
                                    currentsel.put(1, "Left center");
                                    currentsel.put(2, "Custom");
                                final CharSequence[] items = {"Center", "Left center", "Custom"};
                                builder = new AlertDialog.Builder(context);
                                builder.setTitle("Select start location\n\tCurrent selection is: " + currentsel.get(modelvars.position_cells));
                                builder.setItems(items, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int item) {
                                        // Do something with the selection
                                        if (item == 2) {
                                            LayoutInflater inflater = getLayoutInflater();
                                            final View dialoglayout_startloc = inflater.inflate(R.layout.startloc, null);
                                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                            builder.setView(dialoglayout_startloc);
                                            EditText mxsize_et = (EditText) dialoglayout_startloc.findViewById(R.id.startx_id);
                                            EditText mysize_et = (EditText) dialoglayout_startloc.findViewById(R.id.starty_id);
                                            mxsize_et.setText(String.valueOf(modelvars.ini_pos_x));
                                            mysize_et.setText(String.valueOf(modelvars.ini_pos_y));

                                            builder.setTitle("Edit");
                                            // set dialog message
                                            builder
                                                    .setMessage("Start position in " + modelvars.matrix_x +"X" + modelvars.matrix_y + " matrix")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK",
                                                            new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int id) {
                                                                    EditText mxsize_et = (EditText) dialoglayout_startloc.findViewById(R.id.startx_id);
                                                                    EditText mysize_et = (EditText) dialoglayout_startloc.findViewById(R.id.starty_id);
                                                                    double xx = Double.parseDouble(mxsize_et.getText().toString());
                                                                    double yy = Double.parseDouble(mysize_et.getText().toString());
                                                                    if((xx <= modelvars.matrix_x) && (yy <= modelvars.matrix_y)) {
                                                                        modelvars.ini_pos_x = xx;
                                                                        modelvars.ini_pos_y = yy;
                                                                        modelvars.position_cells = 2;
                                                                    }
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
                                        }else if(item == 1){
                                            modelvars.ini_pos_x = 0.1;
                                            modelvars.ini_pos_y = modelvars.matrix_y / 2;
                                            modelvars.position_cells = 1;
                                        }else{
                                            modelvars.ini_pos_x = modelvars.matrix_x / 2;
                                            modelvars.ini_pos_y = modelvars.matrix_y / 2;
                                            modelvars.position_cells = 0;
                                        }
                                        dialog.cancel();
                                    }
                                });
                                builder.setPositiveButton("Cancel", null);
                                AlertDialog alert = builder.create();
                                alert.show();
                                break;
                            case 2:
                                currentsel = new HashMap<Integer, String>();
                                    currentsel.put(0, "Right");
                                    currentsel.put(1, "Up");
                                    currentsel.put(2, "Left");
                                    currentsel.put(3, "Down");
                                    currentsel.put(4, "Random");
                                final CharSequence[] items1 = {"Random", "Down", "Left", "Up", "Right"};
                                builder = new AlertDialog.Builder(context);
                                builder.setTitle("Select cell orientation\n\tCurrent selection is: " + currentsel.get(modelvars.orient_cells));
                                builder.setItems(items1, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int item) {
                                        // Do something with the selection
                                        modelvars.orient_cells = Math.abs(item - 4);
                                        dialog.cancel();
                                    }
                                });
                                builder.setPositiveButton("Cancel", null);
                                alert = builder.create();
                                alert.show();
                                break;
                        }
                        break;

                    // TODO
                    case 2:
                        switch(childPosition) {
                            case 0:
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: No gradient\n")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                modelvars.grad_select = 0;
                                                dialog.cancel();
                                            }
                                        })
                                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                                break;
                            case 1:
                                alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Constant activity C(x,y)\n\t\tC(x,y)=K*C*r/((K_on-Koff)/K-C*r),\n\t\tr^2=(x-Lx/2)^2+(y-Ly/2)^2,\n\t\tK and C dep. on Lx and K_on{off}\n")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                modelvars.grad_select = 1;
                                                dialog.cancel();
                                            }
                                        })
                                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog2,int id) {
                                                dialog2.cancel();
                                            }
                                        });
                                alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                                break;
                            case 2:
                                alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Constant activity C(x)" +
                                                "\n\t\tC(x)=K*C*x/((K_on-Koff)/K-C*x),\n\t\twhere K and C constant,\n\t\tdep. on Lx and K_on{off}\n")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                modelvars.grad_select = 2;
                                                dialog.cancel();
                                            }
                                        })
                                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog2,int id) {
                                                dialog2.cancel();
                                            }
                                        });
                                alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                                break;
                            case 3:
                                alertDialogBuilder = new AlertDialog.Builder(context);
                                alertDialogBuilder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Constant activity C(t)" +
                                                "\n\t\tC(t)=K*C*t/((K_on-Koff)/K-C*t),\n\t\twhere K and C constant,\n\t\tdep. on Lx and K_on{off}\n")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog,int id) {
                                                modelvars.grad_select = 3;
                                                dialog.cancel();
                                            }
                                        })
                                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog2,int id) {
                                                dialog2.cancel();
                                            }
                                        });
                                alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                                break;
                            case 4:
                                LayoutInflater inflater = getLayoutInflater();
                                final View dialoglayout_linear = inflater.inflate(R.layout.linear, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_linear);
                                EditText linearx_et = (EditText) dialoglayout_linear.findViewById(R.id.sourcex_id);
                                EditText lineary_et = (EditText) dialoglayout_linear.findViewById(R.id.sourcey_id);
                                EditText maxatt_et = (EditText) dialoglayout_linear.findViewById(R.id.maxatt_id);
                                EditText minatt_et = (EditText) dialoglayout_linear.findViewById(R.id.minatt_id);
                                EditText attadd_et = (EditText) dialoglayout_linear.findViewById(R.id.attadd_id);
                                linearx_et.setText(String.valueOf(modelvars.source_x));
                                lineary_et.setText(String.valueOf(modelvars.source_y));
                                maxatt_et.setText(String.valueOf(modelvars.att_max));
                                minatt_et.setText(String.valueOf(modelvars.att_min));
                                attadd_et.setText(String.valueOf(modelvars.att_rate));
                                builder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Linear f(x)\n\tf(x)=(Max-Min)*x/Lx")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText linearx_et = (EditText) dialoglayout_linear.findViewById(R.id.sourcex_id);
                                                        EditText lineary_et = (EditText) dialoglayout_linear.findViewById(R.id.sourcey_id);
                                                        EditText maxatt_et = (EditText) dialoglayout_linear.findViewById(R.id.maxatt_id);
                                                        EditText minatt_et = (EditText) dialoglayout_linear.findViewById(R.id.minatt_id);
                                                        EditText attadd_et = (EditText) dialoglayout_linear.findViewById(R.id.attadd_id);
                                                        modelvars.source_x = Double.parseDouble(linearx_et.getText().toString());
                                                        modelvars.source_y = Double.parseDouble(lineary_et.getText().toString());
                                                        modelvars.att_max = Double.parseDouble(maxatt_et.getText().toString());
                                                        modelvars.att_min = Double.parseDouble(minatt_et.getText().toString());
                                                        modelvars.att_rate = Double.parseDouble(attadd_et.getText().toString());
                                                        modelvars.grad_select = 4;
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
                            case 5:
                                inflater = getLayoutInflater();
                                final View dialoglayout_g1 = inflater.inflate(R.layout.gausxy, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_g1);
                                linearx_et = (EditText) dialoglayout_g1.findViewById(R.id.sourcexg1_id);
                                lineary_et = (EditText) dialoglayout_g1.findViewById(R.id.sourceyg1_id);
                                maxatt_et = (EditText) dialoglayout_g1.findViewById(R.id.maxattg1_id);
                                EditText std_et = (EditText) dialoglayout_g1.findViewById(R.id.stdev_id);
                                attadd_et = (EditText) dialoglayout_g1.findViewById(R.id.attaddg1_id);
                                linearx_et.setText(String.valueOf(modelvars.source_x));
                                lineary_et.setText(String.valueOf(modelvars.source_y));
                                maxatt_et.setText(String.valueOf(modelvars.att_max));
                                std_et.setText(String.valueOf(modelvars.g_sigma));
                                attadd_et.setText(String.valueOf(modelvars.att_rate));
                                builder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Gaussian G(x,y)\n\tG(x,y)=Max*exp(-r^2/(2*sigma^2),\n\t" +
                                                "r^2=(x-Xs)^2+(y-Ys)^2")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText linearx_et = (EditText) dialoglayout_g1.findViewById(R.id.sourcexg1_id);
                                                        EditText lineary_et = (EditText) dialoglayout_g1.findViewById(R.id.sourceyg1_id);
                                                        EditText maxatt_et = (EditText) dialoglayout_g1.findViewById(R.id.maxattg1_id);
                                                        EditText std_et = (EditText) dialoglayout_g1.findViewById(R.id.stdev_id);
                                                        EditText attadd_et = (EditText) dialoglayout_g1.findViewById(R.id.attaddg1_id);
                                                        modelvars.source_x = Double.parseDouble(linearx_et.getText().toString());
                                                        modelvars.source_y = Double.parseDouble(lineary_et.getText().toString());
                                                        modelvars.att_max = Double.parseDouble(maxatt_et.getText().toString());
                                                        modelvars.g_sigma = Double.parseDouble(std_et.getText().toString());
                                                        modelvars.att_rate = Double.parseDouble(attadd_et.getText().toString());
                                                        modelvars.grad_select = 5;
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
                            case 6:inflater = getLayoutInflater();
                                final View dialoglayout_g2 = inflater.inflate(R.layout.gausx, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_g2);
                                linearx_et = (EditText) dialoglayout_g2.findViewById(R.id.sourcexg2_id);
                                maxatt_et = (EditText) dialoglayout_g2.findViewById(R.id.maxattg2_id);
                                std_et = (EditText) dialoglayout_g2.findViewById(R.id.stdevg2_id);
                                attadd_et = (EditText) dialoglayout_g2.findViewById(R.id.attaddg2_id);
                                linearx_et.setText(String.valueOf(modelvars.source_x));
                                maxatt_et.setText(String.valueOf(modelvars.att_max));
                                std_et.setText(String.valueOf(modelvars.g_sigma));
                                attadd_et.setText(String.valueOf(modelvars.att_rate));
                                builder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Gaussian G(x)\n\tG(x)=Max*exp(-(x-Xs)^2/(2*sigma^2)")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText linearx_et = (EditText) dialoglayout_g2.findViewById(R.id.sourcexg2_id);
                                                        EditText maxatt_et = (EditText) dialoglayout_g2.findViewById(R.id.maxattg2_id);
                                                        EditText std_et = (EditText) dialoglayout_g2.findViewById(R.id.stdevg2_id);
                                                        EditText attadd_et = (EditText) dialoglayout_g2.findViewById(R.id.attaddg2_id);
                                                        modelvars.source_x = Double.parseDouble(linearx_et.getText().toString());
                                                        modelvars.att_max = Double.parseDouble(maxatt_et.getText().toString());
                                                        modelvars.g_sigma = Double.parseDouble(std_et.getText().toString());
                                                        modelvars.att_rate = Double.parseDouble(attadd_et.getText().toString());
                                                        modelvars.grad_select = 6;
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
                            //TODO
                            case 7:
                                inflater = getLayoutInflater();
                                final View dialoglayout_expt = inflater.inflate(R.layout.expt, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_expt);
                                EditText expt_et = (EditText) dialoglayout_expt.findViewById(R.id.attaddet_id);
                                expt_et.setText(String.valueOf(modelvars.att_rate));
                                builder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Exponential E(t)\n\tE(t)=Rate*exp(t)\n\n\n\tRate of attr. adding, mM/s")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText expt_et = (EditText) dialoglayout_expt.findViewById(R.id.attaddet_id);
                                                        modelvars.att_rate = Double.parseDouble(expt_et.getText().toString());
                                                        modelvars.grad_select = 7;
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
                            case 8:
                                inflater = getLayoutInflater();
                                final View dialoglayout_expx = inflater.inflate(R.layout.expx, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_expx);
                                EditText expx_et = (EditText) dialoglayout_expx.findViewById(R.id.attaddex_id);
                                expx_et.setText(String.valueOf(modelvars.att_rate));
                                builder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Exponential E(x)\n\tE(t)=Rate*exp(x)\n\n\n\tRate of attr. adding, mM/s")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText expx_et = (EditText) dialoglayout_expx.findViewById(R.id.attaddex_id);
                                                        modelvars.att_rate = Double.parseDouble(expx_et.getText().toString());
                                                        modelvars.grad_select = 8;
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
                            case 9:
                                inflater = getLayoutInflater();
                                final View dialoglayout_step = inflater.inflate(R.layout.step, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_step);
                                EditText step_et = (EditText) dialoglayout_step.findViewById(R.id.step_id);
                                step_et.setText(String.valueOf(modelvars.step_val));
                                EditText add_et = (EditText) dialoglayout_step.findViewById(R.id.add_id);
                                add_et.setText(String.valueOf(modelvars.add_step));
                                EditText rem_et = (EditText) dialoglayout_step.findViewById(R.id.rem_id);
                                rem_et.setText(String.valueOf(modelvars.rem_step));
                                builder
                                        .setMessage("Currently selected: " + listsel.get(modelvars.grad_select) + "\nPlease confirm: Stepwise")
                                        .setCancelable(false)
                                        .setPositiveButton("Select",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText step_et = (EditText) dialoglayout_step.findViewById(R.id.step_id);
                                                        modelvars.step_val = Double.parseDouble(step_et.getText().toString());
                                                        EditText add_et = (EditText) dialoglayout_step.findViewById(R.id.add_id);
                                                        modelvars.add_step = Double.parseDouble(add_et.getText().toString());
                                                        EditText rem_et = (EditText) dialoglayout_step.findViewById(R.id.rem_id);
                                                        modelvars.rem_step = Double.parseDouble(rem_et.getText().toString());
                                                        modelvars.grad_select = 9;
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
                    case 3:
                        switch(childPosition) {
                            case 0:
                                LayoutInflater inflater = getLayoutInflater();
                                final View dialoglayout_nmotors = inflater.inflate(R.layout.nmotor, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_nmotors);
                                EditText nmotors_et = (EditText) dialoglayout_nmotors.findViewById(R.id.nmotors_id);
                                nmotors_et.setText(String.valueOf(modelvars.n_motors));
                                // set dialog message
                                builder
                                        .setMessage("Change number of motors")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText nmotors_et = (EditText) dialoglayout_nmotors.findViewById(R.id.nmotors_id);
                                                        modelvars.n_motors = Integer.parseInt(nmotors_et.getText().toString());
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
                                final View dialoglayout_diff = inflater.inflate(R.layout.rotdiff, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_diff);
                                EditText diff_et = (EditText) dialoglayout_diff.findViewById(R.id.diff_id);
                                diff_et.setText(String.valueOf(modelvars.diff_const));
                                // set dialog message
                                builder
                                        .setMessage("Rotary diffusion (rad2/s)")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText diff_et = (EditText) dialoglayout_diff.findViewById(R.id.nmotors_id);
                                                        modelvars.diff_const = Double.parseDouble(diff_et.getText().toString());
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
                                final View dialoglayout_speed = inflater.inflate(R.layout.speed, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_speed);
                                EditText speed_et = (EditText) dialoglayout_speed.findViewById(R.id.speed_id);
                                speed_et.setText(String.valueOf(modelvars.cell_velocity));
                                // set dialog message
                                builder
                                        .setMessage("Speed (cm/s)")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText speed_et = (EditText) dialoglayout_speed.findViewById(R.id.speed_id);
                                                        modelvars.cell_velocity = Double.parseDouble(speed_et.getText().toString());
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
                                final View dialoglayout_rest = inflater.inflate(R.layout.resting, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_rest);
                                EditText rest_et = (EditText) dialoglayout_rest.findViewById(R.id.rest_id);
                                rest_et.setText(String.valueOf(modelvars.rest_rate));
                                // set dialog message
                                builder
                                        .setMessage("Resting motor bias (ccw)")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int id) {
                                                        EditText rest_et = (EditText) dialoglayout_rest.findViewById(R.id.rest_id);
                                                        modelvars.rest_rate = Double.parseDouble(rest_et.getText().toString());
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
                                final Map<Integer, String> currentsel = new HashMap<Integer, String>();
                                currentsel.put(0, "Liquid");
                                currentsel.put(1, "Agar");
                                final CharSequence[] items1 = {"Liquid (3D)","Agar (2D)"};
                                builder = new AlertDialog.Builder(context);
                                builder.setTitle("Select medium\n\tCurrent selection is: " + currentsel.get(modelvars.medium_num));
                                builder.setItems(items1, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int item) {
                                        // Do something with the selection
                                        modelvars.medium_num = item;
                                        dialog.cancel();
                                    }
                                });
                                builder.setPositiveButton("Cancel", null);
                                AlertDialog alert = builder.create();
                                alert.show();
                                break;
                            case 5:
                                final Map<Integer, String> currentsel1 = new HashMap<Integer, String>();
                                currentsel1.put(0, "Reflective");
                                currentsel1.put(1, "Periodic");
                                final CharSequence[] items2 = {"Reflective (non-penetrating)","Periodic (penetrating)"};
                                builder = new AlertDialog.Builder(context);
                                builder.setTitle("Select boundary type\n\tCurrent selection is: " + currentsel1.get(modelvars.bound_select));
                                builder.setItems(items2, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int item) {
                                        // Do something with the selection
                                        modelvars.bound_select = item;
                                        dialog.cancel();
                                    }
                                });
                                builder.setPositiveButton("Cancel", null);
                                alert = builder.create();
                                alert.show();
                                break;
                        }
                        break;
                    case 4:
                        switch(childPosition) {
                            case 0:
                                LayoutInflater inflater = getLayoutInflater();
                                final View dialoglayout_chea = inflater.inflate(R.layout.chea, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_chea);
                                EditText cheap = (EditText) dialoglayout_chea.findViewById(R.id.pchea_id);
                                EditText chear = (EditText) dialoglayout_chea.findViewById(R.id.rchea_id);
                                cheap.setText(String.valueOf(modelvars.chea));
                                chear.setText(String.valueOf(modelvars.autophos));
                                // set dialog message
                                builder
                                        .setMessage("CheA properties")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText cheap = (EditText) dialoglayout_chea.findViewById(R.id.pchea_id);
                                                        EditText chear = (EditText) dialoglayout_chea.findViewById(R.id.rchea_id);
                                                        modelvars.chea = Double.parseDouble(cheap.getText().toString());
                                                        modelvars.autophos = Double.parseDouble(chear.getText().toString());
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
                                final View dialoglayout_cheb = inflater.inflate(R.layout.cheb, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_cheb);
                                EditText chebp = (EditText) dialoglayout_cheb.findViewById(R.id.pcheb_id);
                                EditText chebr = (EditText) dialoglayout_cheb.findViewById(R.id.rcheb_id);
                                chebp.setText(String.valueOf(modelvars.cheb));
                                chebr.setText(String.valueOf(modelvars.bcat));
                                // set dialog message
                                builder
                                        .setMessage("CheB properties")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText chebp = (EditText) dialoglayout_cheb.findViewById(R.id.pcheb_id);
                                                        EditText chebr = (EditText) dialoglayout_cheb.findViewById(R.id.rcheb_id);
                                                        modelvars.cheb = Double.parseDouble(chebp.getText().toString());
                                                        modelvars.bcat = Double.parseDouble(chebr.getText().toString());
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
                                final View dialoglayout_cher = inflater.inflate(R.layout.cher, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_cher);
                                EditText cherp = (EditText) dialoglayout_cher.findViewById(R.id.pcher_id);
                                EditText cherr = (EditText) dialoglayout_cher.findViewById(R.id.rcher_id);
                                cherp.setText(String.valueOf(modelvars.cher));
                                cherr.setText(String.valueOf(modelvars.rcat));
                                // set dialog message
                                builder
                                        .setMessage("CheR properties")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText cherp = (EditText) dialoglayout_cher.findViewById(R.id.pcher_id);
                                                        EditText cherr = (EditText) dialoglayout_cher.findViewById(R.id.rcher_id);
                                                        modelvars.cher = Double.parseDouble(cherp.getText().toString());
                                                        modelvars.rcat = Double.parseDouble(cherr.getText().toString());
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
                                final View dialoglayout_chey = inflater.inflate(R.layout.chey, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_chey);
                                EditText cheyp = (EditText) dialoglayout_chey.findViewById(R.id.pchey_id);
                                EditText cheyr = (EditText) dialoglayout_chey.findViewById(R.id.rchey_id);
                                cheyp.setText(String.valueOf(modelvars.chey));
                                cheyr.setText(String.valueOf(modelvars.yphos));
                                // set dialog message
                                builder
                                        .setMessage("CheY properties")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText cheyp = (EditText) dialoglayout_chey.findViewById(R.id.pchey_id);
                                                        EditText cheyr = (EditText) dialoglayout_chey.findViewById(R.id.rchey_id);
                                                        modelvars.chey = Double.parseDouble(cheyp.getText().toString());
                                                        modelvars.yphos = Double.parseDouble(cheyr.getText().toString());
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
                                final View dialoglayout_chez = inflater.inflate(R.layout.chez, null);
                                builder = new AlertDialog.Builder(context);
                                builder.setView(dialoglayout_chez);
                                EditText chezp = (EditText) dialoglayout_chez.findViewById(R.id.pchez_id);
                                EditText chezr = (EditText) dialoglayout_chez.findViewById(R.id.rchez_id);
                                chezp.setText(String.valueOf(modelvars.chez));
                                chezr.setText(String.valueOf(modelvars.zphos));
                                // set dialog message
                                builder
                                        .setMessage("CheZ properties")
                                        .setCancelable(false)
                                        .setPositiveButton("OK",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        EditText chezp = (EditText) dialoglayout_chez.findViewById(R.id.pchez_id);
                                                        EditText chezr = (EditText) dialoglayout_chez.findViewById(R.id.rchez_id);
                                                        modelvars.chez = Double.parseDouble(chezp.getText().toString());
                                                        modelvars.zphos = Double.parseDouble(chezr.getText().toString());
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
                            case 5:
                                break;
                            case 6:
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
        gradientlist.add("No gradient");
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
        networklist.add("Receptor ligand KD-S");
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
