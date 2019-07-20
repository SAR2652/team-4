package com.example.varun.cfg;


import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
//import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class ArActivity extends AppCompatActivity {

    private ArFragment arFragment;

    String modelLink;
    float size;
    AnchorNode anchorNode[];
    TransformableNode transformableNode[];
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);

        //getIntentDataAr();

        modelLink = "Chair.sfb";
        size = 1.0f;
        counter = 0;
        anchorNode = new AnchorNode[10];
        transformableNode = new TransformableNode[10];

        getIntentDataAr();

//        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ar_fragment);
//        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
//            Anchor anchor = hitResult.createAnchor();
//
//            ModelRenderable.builder()
//                    .setSource(this, RenderableSource.builder().setSource(this,
//                            Uri.parse(modelLink),
//                            RenderableSource.SourceType.GLTF2)
//                            .setScale(size)  // Scale the original model to 50%.
//                            .build())
//                    .setRegistryId(modelLink)
//                    .build()
//                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable))
//                    .exceptionally(throwable -> {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                        builder.setMessage(throwable.getMessage()).show();
//                        return null;
//                    });
//        });

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ar_fragment);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(this, Uri.parse(modelLink))
                    .setRegistryId(modelLink)
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable))
                    .exceptionally(throwable -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage(throwable.getMessage()).show();
                        return null;
                    });
        });

    }

    private void getIntentDataAr() {
        Log.d("hi", "getIntentDataAr: ");
        if (getIntent().hasExtra("arSource") && getIntent().hasExtra("arSize"))
        {
            modelLink = getIntent().getStringExtra("arSource");
            Log.d("hi", modelLink);
            size = Float.parseFloat(getIntent().getStringExtra("arSize"));
        }
    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {
        counter++;
        anchorNode[counter] = new AnchorNode(anchor);
        transformableNode[counter] = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode[counter].setParent(anchorNode[counter]);
        transformableNode[counter].setRenderable(modelRenderable);
        Vector3 vector3 = new Vector3(0.01f,0.01f,0.01f);
        transformableNode[counter].setLocalScale(vector3);
        transformableNode[counter].getScaleController().setMaxScale(2.0f);
        transformableNode[counter].getScaleController().setMinScale(size);
        //transformableNode.setLocalRotation(Quaternion.axisAngle(new Vector3(0,0,1f),180));
        arFragment.getArSceneView().getScene().addChild(anchorNode[counter]);
        transformableNode[counter].select();
    }

    public void btnArRemove(View view) {


        transformableNode[counter].setParent(null);
        anchorNode[counter].getAnchor().detach();
        counter--;

    }
}
