package listexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.codelearn.codelearnlistexample.R;

import java.util.ArrayList;
import java.util.List;


public class ListViewWithBaseAdapter extends Activity {

	public class codeLeanChapter {
		String chapterName;
		String chapterDescription;
	}
	CodeLearnAdapter chapterListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_simple_adapter);
        
     
        chapterListAdapter = new CodeLearnAdapter();
        
        ListView codeLearnLessons = (ListView)findViewById(R.id.listView1);
        codeLearnLessons.setAdapter(chapterListAdapter);
        
        codeLearnLessons.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				codeLeanChapter chapter = chapterListAdapter.getCodeLearnChapter(arg2);
				
				Toast.makeText(ListViewWithBaseAdapter.this, chapter.chapterName,Toast.LENGTH_LONG).show();
				
			}
		});

		codeLearnLessons.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

			}
		});
    }


    public class CodeLearnAdapter extends BaseAdapter {

    	List<codeLeanChapter> codeLeanChapterList = getDataForListView();
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return codeLeanChapterList.size();
		}

		@Override
		public codeLeanChapter getItem(int arg0) {
			// TODO Auto-generated method stub
			return codeLeanChapterList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View arg1, ViewGroup arg2) {
			
			if(arg1==null)
			{
				LayoutInflater inflater = (LayoutInflater) ListViewWithBaseAdapter.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				arg1 = inflater.inflate(R.layout.listitem, arg2,false);
			}
			
			TextView chapterName = (TextView)arg1.findViewById(R.id.textView1);
			TextView chapterDesc = (TextView)arg1.findViewById(R.id.textView2);
			
			codeLeanChapter chapter = codeLeanChapterList.get(position);
			
			chapterName.setText(chapter.chapterName);
			chapterDesc.setText(chapter.chapterDescription);
			
			return arg1;
		}
		
		public codeLeanChapter getCodeLearnChapter(int position)
		{
			return codeLeanChapterList.get(position);
		}

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_with_simple_adapter, menu);
        return true;
    }
    
    public List<codeLeanChapter> getDataForListView()
    {
    	List<codeLeanChapter> codeLeanChaptersList = new ArrayList<codeLeanChapter>();
    	
    	for(int i=0;i<10;i++)
    	{
    		
    		codeLeanChapter chapter = new codeLeanChapter();
    		chapter.chapterName = "Chapter "+i;
    		chapter.chapterDescription = "This is description for chapter "+i;
    		codeLeanChaptersList.add(chapter);
    	}
    	
    	return codeLeanChaptersList;
    	
    }
}
