using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class HorizontalLine : MonoBehaviour
{

    SpriteRenderer m_SpriteRenderer;
    //The Color to be assigned to the Renderer’s Material
    Color m_NewColor;
    private bool clicked;
    private TextChanger textScript;
    public GameObject handler;
    public GameObject playerText;

    // Start is called before the first frame update
    void Start()
    {
        clicked = false;

        textScript = handler.gameObject.GetComponent<TextChanger>();
        textScript.score = true;

        //Fetch the SpriteRenderer from the GameObject
        m_SpriteRenderer = GetComponent<SpriteRenderer>();
        //Set the GameObject's Color quickly to a set Color (blue)
        m_SpriteRenderer.color = Color.white;
    }

    void OnMouseOver()
    {
        if (!clicked)
        {
            //If your mouse hovers over the GameObject with the script attached, output this message
            Debug.Log("Mouse is over GameObject.");
            m_SpriteRenderer.color = Color.red;
        }

        if (!clicked && Input.GetMouseButtonDown(0) && textScript.score)
        {
            //If your mouse hovers over the GameObject with the script attached, output this message
            Debug.Log("Mouse is over GameObject.");
            m_SpriteRenderer.color = Color.blue;
            clicked = true;
            textScript.score = false;
        }
        else if (!clicked && Input.GetMouseButtonDown(0) && !textScript.score)
        {
            //If your mouse hovers over the GameObject with the script attached, output this message
            Debug.Log("Mouse is over GameObject.");
            m_SpriteRenderer.color = Color.green;
            clicked = true;
            textScript.score = true;
        }
    }

    void OnMouseExit()
    {
        if (!clicked)
        {
            //The mouse is no longer hovering over the GameObject so output this message each frame
            Debug.Log("Mouse is no longer on GameObject.");
            m_SpriteRenderer.color = Color.white;
        }
    }

    // Update is called once per frame
    void Update()
    {

    }
}
