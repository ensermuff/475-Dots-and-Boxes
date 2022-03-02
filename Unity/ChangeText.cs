using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine;

public class ChangeText : MonoBehaviour
{
    public GameObject textChange;
    public Text playerTurn;
    TextChanger textScript;

    // Start is called before the first frame update
    void Start()
    {
        textScript = textChange.gameObject.GetComponent<TextChanger>();
        playerTurn.text = "Player 1";
    }

    // Update is called once per frame
    void Update()
    {
        if (textScript.score)
        {
            playerTurn.text = "Player 1";
        }
        else if (!textScript.score)
        {
            playerTurn.text = "Player 2";
        }
    }
}
