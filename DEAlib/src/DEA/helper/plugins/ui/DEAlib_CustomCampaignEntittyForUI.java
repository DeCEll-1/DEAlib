package DEA.helper.plugins.ui;

import DEA.helper.render.DEAlib_RenderPluginFunctions;
import DEA.helper.render.renderClassesFolder.DEAlib_BoxData;
import DEA.helper.render.renderClassesFolder.DEAlib_LineData;
import DEA.helper.render.renderClassesFolder.DEAlib_LineWWidthData;
import DEA.helper.render.renderClassesFolder.DEAlib_PolygonWHeightAndCenterData;
import cmu.gui.CMUKitUI;
import com.fs.starfarer.api.campaign.CampaignEngineLayers;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.combat.CombatEngineLayers;
import com.fs.starfarer.api.combat.ViewportAPI;
import com.fs.starfarer.api.impl.campaign.BaseCustomEntityPlugin;
import com.fs.starfarer.campaign.CampaignEntity;
import com.fs.starfarer.campaign.CustomCampaignEntity;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

public class DEAlib_CustomCampaignEntittyForUI extends BaseCustomEntityPlugin {

    public DEAlib_CustomCampaignEntittyForUI(SectorEntityToken plugin) {
        this.entity = plugin;
    }

    public DEAlib_CustomCampaignEntittyForUI() {
    }

    private CampaignEngineLayers CURRENT_LAYER = CampaignEngineLayers.ABOVE;

    private HashMap<String, DEAlib_LineData> lines;
    private HashMap<String, DEAlib_LineWWidthData> lineWWidths;
    private HashMap<String, DEAlib_PolygonWHeightAndCenterData> PolygonWHeightAndCenters;
    private HashMap<String, DEAlib_BoxData> boxDatas;

    @Override
    public void init(SectorEntityToken entity, Object pluginParams) {
        this.entity = entity;
    }

    @Override
    public float getRenderRange() {
        return Float.MAX_VALUE;
    }

    @Override
    public boolean isMapTooltipExpandable() {
        return false;
    }

    @Override
    public boolean hasCustomMapTooltip() {
        return false;
    }

    @Override
    public void render(CampaignEngineLayers layer, ViewportAPI viewport) {
        //this shit doesnt even run and GOD KNOWS WHY İT DOESNT HELP AAAAAAAAAA
        //its probably about the frenching init but i dont know what the hell to put in it because its a froaping OBJECT how the f am i suppose to know what to put there? int? string? float? AAAAAAAAAAAAAAAAAAAAAAAAAAA

        CMUKitUI.openGLForMisc();


        if (lines != null) {
            if (lines.size() != 0) {
                for (Map.Entry<String, DEAlib_LineData> line : lines.entrySet()) {
                    DEAlib_RenderPluginFunctions.DEAlib_DrawLineForPlugin(line.getValue().from, line.getValue().to, line.getValue().lineColor, viewport);
                }
            }
        }

        if (lineWWidths != null) {

            if (lineWWidths.size() != 0) {
                for (Map.Entry<String, DEAlib_LineWWidthData> lineWWidth : lineWWidths.entrySet()) {
                    DEAlib_RenderPluginFunctions.DEAlib_DrawLineWWidthForPlugin(lineWWidth.getValue().fromCenter, lineWWidth.getValue().toCenter, lineWWidth.getValue().width, lineWWidth.getValue().lineColor, viewport);
                }
            }
        }

        if (PolygonWHeightAndCenters != null) {
            if (PolygonWHeightAndCenters.size() != 0) {
                for (Map.Entry<String, DEAlib_PolygonWHeightAndCenterData> PolygonWHeightAndCenter : PolygonWHeightAndCenters.entrySet()) {
                    DEAlib_RenderPluginFunctions.DEAlib_DrawPolygonWHeightAndCenter(PolygonWHeightAndCenter.getValue().center, PolygonWHeightAndCenter.getValue().sides, PolygonWHeightAndCenter.getValue().circleAngle, PolygonWHeightAndCenter.getValue().height, PolygonWHeightAndCenter.getValue().lineColor, viewport);
                }
            }
        }

        if (boxDatas != null) {
            if (boxDatas.size() != 0) {
                for (Map.Entry<String, DEAlib_BoxData> BoxData : boxDatas.entrySet()) {
                    DEAlib_RenderPluginFunctions.DEAlib_DrawBox(BoxData.getValue().leftTop, BoxData.getValue().rightTop, BoxData.getValue().leftBottom, BoxData.getValue().rightBottom, BoxData.getValue().lineColor, BoxData.getValue().PolygonModeMode, viewport);
                }
            }
        }

//        glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
//        glDisable(GL_TEXTURE_2D);//doesnt work without this
//        glBegin(GL_TRIANGLE_STRIP);

//        glVertex2f(viewport.convertScreenXToWorldX(0), viewport.convertScreenYToWorldY(1));
//        glVertex2f(viewport.convertScreenXToWorldX(1), viewport.convertScreenYToWorldY(1));
//        glVertex2f(viewport.convertScreenXToWorldX(0), viewport.convertScreenYToWorldY(0));
//        glVertex2f(viewport.convertScreenXToWorldX(1), viewport.convertScreenYToWorldY(0));
//
//        glEnd();
////        glFlush();
//        glEnable(GL_TEXTURE_2D);
//
        CMUKitUI.closeGLForMisc();
    }

    public void DEAlib_DrawLineInPlugin(HashMap<String, DEAlib_LineData> lines) {
        if (lines == null) this.lines = new HashMap<String, DEAlib_LineData>();
        this.lines.clear();
        this.lines = new HashMap<String, DEAlib_LineData>();
        this.lines.putAll(lines);
    }

    public void DEAlib_DrawLineWWidth(HashMap<String, DEAlib_LineWWidthData> lineWWidths) {
        if (lineWWidths == null) this.lineWWidths = new HashMap<String, DEAlib_LineWWidthData>();
        this.lineWWidths.clear();
        this.lineWWidths = new HashMap<String, DEAlib_LineWWidthData>();
        this.lineWWidths.putAll(lineWWidths);
    }

    public void DEAlib_DrawPolygonWHeightAndCenter(HashMap<String, DEAlib_PolygonWHeightAndCenterData> PolygonWHeightAndCenters) {
        if (PolygonWHeightAndCenters == null) this.PolygonWHeightAndCenters = new HashMap<String, DEAlib_PolygonWHeightAndCenterData>();
        this.PolygonWHeightAndCenters.clear();
        this.PolygonWHeightAndCenters = new HashMap<String, DEAlib_PolygonWHeightAndCenterData>();
        this.PolygonWHeightAndCenters.putAll(PolygonWHeightAndCenters);
    }

    public void DEAlib_DrawBoxIn(HashMap<String, DEAlib_BoxData> DEA_BoxDatas) {
        if (boxDatas == null) this.boxDatas = new HashMap<String, DEAlib_BoxData>();
        this.boxDatas.clear();
        this.boxDatas = new HashMap<String, DEAlib_BoxData>();
        this.boxDatas.putAll(DEA_BoxDatas);
    }


}