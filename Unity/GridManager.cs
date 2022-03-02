using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GridManager : MonoBehaviour
{
    public int[,] Grid;
    int Vertical, Horizontal, Columns, Rows, Columns2, Rows2, Columns3, Rows3, Columns4, Rows4;
    public GameObject Dot;
    public GameObject HLine;
    public GameObject VLine;
    public GameObject Squares;
    
    // Start is called before the first frame update
    void Start()
    {
        //Vertical = (int)Camera.main.orthographicSize;
        //Horizontal = Vertical * (Screen.width / Screen.height);
        
        //This sets up all the dots in the player screen
        Columns = 4;
        Rows = 4;
        Grid = new int[Columns, Rows];
        for(int i = 0; i < Columns; i++){
            for(int j = 0; j < Rows; j++){
                //Grid[i, j] = Random.Range(0, 10);

                float Out = 1.5f;
                
                    //assigns the dots to offset from zero and spaces them out evenly
                    Vector2 location = new Vector2((i - Out) * Out, (j - Out) * Out);
                    PlaceObject(location, Dot);
            }
        }

        //This sets up all the Horizontal Lines on the grid
        Columns2 = 3;
        Rows2 = 4;
        for (int i = 0; i < Columns2; i++)
        {
            for (int j = 0; j < Rows2; j++)
            {
                float Out = 1.5f;
                float offSet = 1.0f;

                //assigns the Horizontal Lines to offset from zero and spaces them out evenly
                Vector2 location2 = new Vector2((i - offSet) * Out, (j - Out) * Out);
                PlaceObject(location2, HLine);

                
            }
        }

        //this sets up the vertical Lines on the grid
        Columns3 = 4;
        Rows3 = 3;
        for (int i = 0; i < Columns3; i++)
        {
            for (int j = 0; j < Rows3; j++)
            {
                float Out = 1.5f;
                float offSet = 1.0f;

                //assigns the Vertical Lines to offset from zero and spaces them out evenly
                Vector2 location3 = new Vector2((i - Out) * Out, (j - offSet) * Out);
                PlaceObject(location3, VLine);
            }
        }

        //this sets up the squares on the grid
        Columns4 = 3;
        Rows4 = 3;
        for (int i = 0; i < Columns4; i++)
        {
            for (int j = 0; j < Rows4; j++)
            {
                float Out = 1.5f;
                float offSet = 1.0f;

                //assigns the Squares to offset from zero and spaces them out evenly
                Vector2 location4 = new Vector2((i - offSet) * Out, (j - offSet) * Out);
                PlaceObject(location4, Squares);
            }
        }
    }

    public void PlaceObject(Vector2 location, GameObject obj)
    {
        Instantiate(obj, location, Quaternion.identity);
    }


    // Update is called once per frame
    void Update()
    {
        
    }
}
