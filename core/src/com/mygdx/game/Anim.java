package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import sun.jvm.hotspot.gc.g1.G1CollectedHeap;

public class Anim {
    private Texture img;
    private TextureAtlas atlas;
    private Animation<TextureRegion> anm;
    private float time;

    public Anim(String atlasName, String pictureName, Animation.PlayMode playMode, float frameDuration) {
        atlas = new TextureAtlas(atlasName);
        anm =new Animation<TextureRegion>(frameDuration, atlas.findRegions(pictureName));
        anm.setPlayMode(playMode);
        time+=Gdx.graphics.getDeltaTime();
    }

    public Anim(String name, int col, int row, Animation.PlayMode playMode) {
        img = new Texture(name);
        TextureRegion region0 = new TextureRegion(img);
        int xCnt = region0.getRegionWidth() / col;
        int yCnt = region0.getRegionHeight() / row;
        TextureRegion[][] regions0 = region0.split(xCnt, yCnt);

        TextureRegion[] region1 = new TextureRegion[regions0.length * regions0[0].length];
        int cnt = 0;

        for (int i = 0; i < regions0.length; i++) {
            for (int j = 0; j < regions0[0].length; j++) {
                region1[cnt++] = regions0[i][j];

            }

        }

        atlas = new TextureAtlas("atlas/unnamed");
        anm = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(1 / 15f, atlas.findRegions("Ladder"));
        /*anm = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(1 / 15f, region1);*/

        anm.setPlayMode(playMode);

        time += Gdx.graphics.getDeltaTime();

    }

    public TextureRegion getFrame() {
        return anm.getKeyFrame(time);
    }

    public void setTime(float time) {
        this.time += time;

    }

    public void zeroTime() {
        this.time = 0;
    }

    public boolean isAnimationOver() {
        return anm.isAnimationFinished(time);
    }

    public void setPlayMode(Animation.PlayMode playMode) {
        anm.setPlayMode(playMode);
    }

    public void dispose() {
        atlas.dispose();
    }

}
