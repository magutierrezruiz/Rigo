package com.example.algebraventura;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final int PURPLE = Color.rgb(82, 45, 154);
    private static final int PURPLE_DARK = Color.rgb(55, 32, 107);
    private static final int PURPLE_LIGHT = Color.rgb(239, 232, 255);
    private static final int GREEN = Color.rgb(37, 138, 92);
    private static final int GREEN_LIGHT = Color.rgb(226, 246, 235);
    private static final int RED = Color.rgb(190, 55, 55);
    private static final int RED_LIGHT = Color.rgb(255, 232, 232);
    private static final int TEXT = Color.rgb(35, 31, 42);
    private static final int MUTED = Color.rgb(101, 95, 112);
    private static final int WHITE = Color.WHITE;

    private int current = 0;
    private int score = 0;
    private int lives = 3;
    private boolean answered = false;

    private final Challenge[] challenges = new Challenge[] {
        new Challenge(
                "Mundo 1 · La Plaza del Cuadrado",
                "Reto 1",
                "Desarrolla (x + 4)².",
                new String[]{"x² + 8x + 16", "x² + 16", "x² + 4x + 16", "x² + 8"},
                0,
                "(a + b)² = a² + 2ab + b². Entonces (x + 4)² = x² + 8x + 16."
        ),
        new Challenge(
                "Mundo 1 · La Plaza del Cuadrado",
                "Reto 2",
                "¿Cuál es el área de un cuadrado cuyo lado mide (m + 3)?",
                new String[]{"m² + 3", "m² + 6m + 9", "m² + 9", "2m + 6"},
                1,
                "El área es lado × lado: (m + 3)² = m² + 6m + 9."
        ),
        new Challenge(
                "Mundo 1 · La Plaza del Cuadrado",
                "Reto 3",
                "Completa: (2a + 5)² = 4a² + ___ + 25.",
                new String[]{"10a", "20a", "25a", "4a"},
                1,
                "El término central es 2(2a)(5) = 20a."
        ),
        new Challenge(
                "Mundo 2 · El Valle de la Diferencia",
                "Reto 4",
                "Desarrolla (x - 6)².",
                new String[]{"x² - 36", "x² - 12x + 36", "x² + 12x + 36", "x² - 6x + 36"},
                1,
                "(a - b)² = a² - 2ab + b². Por eso: x² - 12x + 36."
        ),
        new Challenge(
                "Mundo 2 · El Valle de la Diferencia",
                "Reto 5",
                "¿Cuál expresión equivale a (3y - 2)²?",
                new String[]{"9y² - 12y + 4", "9y² - 4", "9y² - 6y + 4", "6y² - 12y + 4"},
                0,
                "(3y)² - 2(3y)(2) + 2² = 9y² - 12y + 4."
        ),
        new Challenge(
                "Mundo 2 · El Valle de la Diferencia",
                "Reto 6",
                "Si (p - 7)² = p² - 14p + k, ¿cuánto vale k?",
                new String[]{"7", "14", "49", "98"},
                2,
                "El último término es 7² = 49."
        ),
        new Challenge(
                "Mundo 3 · El Puente de los Conjugados",
                "Reto 7",
                "Resuelve (x + 5)(x - 5).",
                new String[]{"x² - 25", "x² + 25", "x² - 10x + 25", "x² + 10x - 25"},
                0,
                "La suma por diferencia cumple (a + b)(a - b) = a² - b²."
        ),
        new Challenge(
                "Mundo 3 · El Puente de los Conjugados",
                "Reto 8",
                "Simplifica (4m + 3)(4m - 3).",
                new String[]{"16m² - 9", "16m² + 9", "8m² - 9", "16m² - 24m + 9"},
                0,
                "(4m)² - 3² = 16m² - 9."
        ),
        new Challenge(
                "Mundo 3 · El Puente de los Conjugados",
                "Reto 9",
                "¿Qué producto notable produce 25x² - 16?",
                new String[]{"(5x + 4)²", "(5x - 4)²", "(5x + 4)(5x - 4)", "(25x + 16)(x - 1)"},
                2,
                "25x² - 16 es una diferencia de cuadrados: (5x)² - 4²."
        ),
        new Challenge(
                "Mundo 4 · La Fortaleza de los Binomios",
                "Reto 10",
                "Desarrolla (x + 2)(x + 7).",
                new String[]{"x² + 9x + 14", "x² + 14x + 9", "x² + 5x + 14", "x² + 9x + 9"},
                0,
                "x·x + 7x + 2x + 14 = x² + 9x + 14."
        ),
        new Challenge(
                "Mundo 4 · La Fortaleza de los Binomios",
                "Reto 11",
                "¿Cuál es el resultado de (x - 3)(x + 8)?",
                new String[]{"x² + 5x - 24", "x² - 5x - 24", "x² + 11x + 24", "x² + 5x + 24"},
                0,
                "x² + 8x - 3x - 24 = x² + 5x - 24."
        ),
        new Challenge(
                "Mundo 4 · La Fortaleza de los Binomios",
                "Jefe final",
                "Un cuadrado grande tiene lado (x + 5) y se retira un cuadrado pequeño de lado 5. ¿Qué expresión representa el área restante?",
                new String[]{"x² + 10x", "x² + 25", "x² + 10x + 25", "x² + 5x"},
                0,
                "Área restante = (x + 5)² - 5² = x² + 10x + 25 - 25 = x² + 10x."
        )
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private void showHome() {
        ScrollView scroll = baseScroll();
        LinearLayout root = contentColumn();
        scroll.addView(root);

        TextView badge = label("MATEMÁTICAS · GRADO 8°", 13, PURPLE, true);
        badge.setGravity(Gravity.CENTER);
        badge.setBackground(rounded(PURPLE_LIGHT, 999));
        LinearLayout.LayoutParams badgeParams = wrap();
        badgeParams.gravity = Gravity.CENTER_HORIZONTAL;
        badgeParams.bottomMargin = dp(18);
        badge.setLayoutParams(badgeParams);
        badge.setPadding(dp(14), dp(7), dp(14), dp(7));
        root.addView(badge);

        TextView title = label("AlgebrAventura", 34, PURPLE_DARK, true);
        title.setGravity(Gravity.CENTER);
        root.addView(title, matchWrap());

        TextView subtitle = label("El Reino de los Productos Notables", 20, TEXT, true);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subParams = matchWrap();
        subParams.topMargin = dp(6);
        subParams.bottomMargin = dp(24);
        root.addView(subtitle, subParams);

        LinearLayout mission = card();
        mission.addView(label("Tu misión", 20, PURPLE_DARK, true));
        TextView missionText = label(
                "Supera 4 mundos algebraicos, conserva tus 3 vidas y derrota al jefe final aplicando productos notables.",
                16, TEXT, false);
        LinearLayout.LayoutParams mtp = matchWrap();
        mtp.topMargin = dp(10);
        mission.addView(missionText, mtp);
        TextView facts = label("12 retos  ·  100 puntos por acierto  ·  Retroalimentación inmediata", 14, MUTED, false);
        LinearLayout.LayoutParams fp = matchWrap();
        fp.topMargin = dp(12);
        mission.addView(facts, fp);
        root.addView(mission, cardParams());

        addWorld(root, "MUNDO 1", "La Plaza del Cuadrado", "(a + b)²");
        addWorld(root, "MUNDO 2", "El Valle de la Diferencia", "(a - b)²");
        addWorld(root, "MUNDO 3", "El Puente de los Conjugados", "(a + b)(a - b)");
        addWorld(root, "MUNDO 4", "La Fortaleza de los Binomios", "(x + a)(x + b)");

        Button start = primaryButton("COMENZAR AVENTURA");
        start.setOnClickListener(v -> restartGame());
        LinearLayout.LayoutParams sp = matchWrap();
        sp.topMargin = dp(14);
        sp.bottomMargin = dp(22);
        root.addView(start, sp);

        setContentView(scroll);
    }

    private void restartGame() {
        current = 0;
        score = 0;
        lives = 3;
        answered = false;
        showGame();
    }

    private void showGame() {
        final Challenge challenge = challenges[current];

        ScrollView scroll = baseScroll();
        LinearLayout root = contentColumn();
        scroll.addView(root);

        LinearLayout top = new LinearLayout(this);
        top.setOrientation(LinearLayout.HORIZONTAL);
        top.setGravity(Gravity.CENTER_VERTICAL);

        TextView progressText = label("Reto " + (current + 1) + " de " + challenges.length, 14, MUTED, true);
        top.addView(progressText, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        TextView livesText = label(heartText(), 17, RED, true);
        livesText.setGravity(Gravity.RIGHT);
        top.addView(livesText, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        root.addView(top, matchWrap());

        ProgressBar bar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        bar.setMax(challenges.length);
        bar.setProgress(current + 1);
        LinearLayout.LayoutParams bp = matchWrap();
        bp.topMargin = dp(8);
        bp.bottomMargin = dp(18);
        bp.height = dp(8);
        root.addView(bar, bp);

        TextView world = label(challenge.world, 14, PURPLE, true);
        root.addView(world, matchWrap());

        TextView heading = label(challenge.title, 27, PURPLE_DARK, true);
        LinearLayout.LayoutParams hp = matchWrap();
        hp.topMargin = dp(5);
        root.addView(heading, hp);

        LinearLayout questionCard = card();
        TextView prompt = label(challenge.prompt, 21, TEXT, true);
        prompt.setGravity(Gravity.CENTER);
        prompt.setPadding(0, dp(8), 0, dp(8));
        questionCard.addView(prompt, matchWrap());
        LinearLayout.LayoutParams qcp = cardParams();
        qcp.topMargin = dp(16);
        root.addView(questionCard, qcp);

        TextView instruction = label("Selecciona la respuesta correcta:", 15, MUTED, true);
        LinearLayout.LayoutParams ip = matchWrap();
        ip.topMargin = dp(6);
        ip.bottomMargin = dp(8);
        root.addView(instruction, ip);

        final Button[] optionButtons = new Button[challenge.options.length];
        for (int i = 0; i < challenge.options.length; i++) {
            final int selectedIndex = i;
            Button option = optionButton(letter(i) + ".  " + challenge.options[i]);
            option.setOnClickListener(v -> {
                if (!answered) {
                    answered = true;
                    if (selectedIndex == challenge.correctIndex) {
                        score += 100;
                    } else {
                        lives = Math.max(0, lives - 1);
                    }
                    renderAnswered(root, challenge, optionButtons, selectedIndex);
                }
            });
            optionButtons[i] = option;
            LinearLayout.LayoutParams op = matchWrap();
            op.bottomMargin = dp(10);
            root.addView(option, op);
        }

        TextView scoreText = label("Puntaje: " + score, 14, MUTED, true);
        scoreText.setTag("scoreText");
        LinearLayout.LayoutParams scp = matchWrap();
        scp.topMargin = dp(4);
        root.addView(scoreText, scp);

        setContentView(scroll);
    }

    private void renderAnswered(LinearLayout root, Challenge challenge, Button[] optionButtons, int selectedIndex) {
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setEnabled(false);
            if (i == challenge.correctIndex) {
                styleOption(optionButtons[i], GREEN_LIGHT, GREEN);
            } else if (i == selectedIndex) {
                styleOption(optionButtons[i], RED_LIGHT, RED);
            } else {
                styleOption(optionButtons[i], Color.rgb(247, 245, 250), Color.rgb(205, 199, 214));
            }
        }

        TextView existingScore = (TextView) root.findViewWithTag("scoreText");
        if (existingScore != null) {
            existingScore.setText("Puntaje: " + score + "    ·    Vidas: " + lives);
        }

        LinearLayout feedback = card();
        boolean correct = selectedIndex == challenge.correctIndex;
        feedback.setBackground(rounded(correct ? GREEN_LIGHT : RED_LIGHT, 18));

        TextView result = label(correct ? "¡Correcto! +100 puntos" : "Aún no. Revisa la explicación.", 18,
                correct ? GREEN : RED, true);
        feedback.addView(result, matchWrap());

        TextView explanation = label(challenge.explanation, 15, TEXT, false);
        LinearLayout.LayoutParams ep = matchWrap();
        ep.topMargin = dp(8);
        feedback.addView(explanation, ep);

        LinearLayout.LayoutParams fbp = cardParams();
        fbp.topMargin = dp(14);
        root.addView(feedback, fbp);

        Button next = primaryButton((current == challenges.length - 1 || lives == 0) ? "VER RESULTADO" : "SIGUIENTE RETO");
        next.setOnClickListener(v -> {
            if (current == challenges.length - 1 || lives == 0) {
                showResult();
            } else {
                current++;
                answered = false;
                showGame();
            }
        });
        LinearLayout.LayoutParams np = matchWrap();
        np.topMargin = dp(4);
        np.bottomMargin = dp(20);
        root.addView(next, np);
    }

    private void showResult() {
        ScrollView scroll = baseScroll();
        LinearLayout root = contentColumn();
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        scroll.addView(root);

        TextView title = label(lives > 0 ? "¡Misión completada!" : "Fin de la expedición", 30, PURPLE_DARK, true);
        title.setGravity(Gravity.CENTER);
        root.addView(title, matchWrap());

        TextView trophy = label(score >= 1000 ? "★ ★ ★" : score >= 700 ? "★ ★" : "★", 38, PURPLE, true);
        trophy.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams tp = matchWrap();
        tp.topMargin = dp(10);
        root.addView(trophy, tp);

        LinearLayout resultCard = card();
        TextView scoreBig = label(score + " / " + (challenges.length * 100), 34, PURPLE_DARK, true);
        scoreBig.setGravity(Gravity.CENTER);
        resultCard.addView(scoreBig, matchWrap());

        TextView scoreLabel = label("PUNTOS", 13, MUTED, true);
        scoreLabel.setGravity(Gravity.CENTER);
        resultCard.addView(scoreLabel, matchWrap());

        TextView message = label(resultMessage(), 17, TEXT, false);
        message.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams mp = matchWrap();
        mp.topMargin = dp(16);
        resultCard.addView(message, mp);

        TextView livesLeft = label("Vidas restantes: " + lives, 15, MUTED, true);
        livesLeft.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams lp = matchWrap();
        lp.topMargin = dp(12);
        resultCard.addView(livesLeft, lp);
        root.addView(resultCard, cardParams());

        Button replay = primaryButton("JUGAR DE NUEVO");
        replay.setOnClickListener(v -> restartGame());
        LinearLayout.LayoutParams rp = matchWrap();
        rp.topMargin = dp(8);
        root.addView(replay, rp);

        Button home = secondaryButton("VOLVER AL INICIO");
        home.setOnClickListener(v -> showHome());
        LinearLayout.LayoutParams hop = matchWrap();
        hop.topMargin = dp(10);
        hop.bottomMargin = dp(24);
        root.addView(home, hop);

        setContentView(scroll);
    }

    private String resultMessage() {
        if (score >= 1100) return "Dominio sobresaliente. Reconoces y aplicas los productos notables con mucha precisión.";
        if (score >= 800) return "Muy buen trabajo. Tienes una base sólida; revisa los retos en los que dudaste.";
        if (score >= 500) return "Vas por buen camino. Repite la aventura para fortalecer las identidades algebraicas.";
        return "Necesitas reforzar las estructuras básicas. Usa las explicaciones y vuelve a intentarlo.";
    }

    private void addWorld(LinearLayout parent, String number, String name, String formula) {
        LinearLayout world = card();

        TextView n = label(number, 12, PURPLE, true);
        world.addView(n, matchWrap());

        TextView nameView = label(name, 17, TEXT, true);
        LinearLayout.LayoutParams np = matchWrap();
        np.topMargin = dp(3);
        world.addView(nameView, np);

        TextView formulaView = label(formula, 18, PURPLE_DARK, true);
        LinearLayout.LayoutParams fp = matchWrap();
        fp.topMargin = dp(7);
        world.addView(formulaView, fp);

        LinearLayout.LayoutParams wp = cardParams();
        wp.topMargin = dp(9);
        wp.bottomMargin = dp(0);
        parent.addView(world, wp);
    }

    private ScrollView baseScroll() {
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(Color.rgb(250, 248, 253));
        return scroll;
    }

    private LinearLayout contentColumn() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(26), dp(20), dp(20));
        root.setGravity(Gravity.TOP);
        return root;
    }

    private LinearLayout card() {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(18), dp(18), dp(18), dp(18));
        card.setBackground(rounded(WHITE, 18));
        card.setElevation(dp(2));
        return card;
    }

    private TextView label(String text, int sizeSp, int color, boolean bold) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(sizeSp);
        view.setTextColor(color);
        view.setLineSpacing(0, 1.12f);
        if (bold) view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return view;
    }

    private Button primaryButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextColor(WHITE);
        button.setTextSize(15);
        button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        button.setAllCaps(false);
        button.setPadding(dp(14), dp(12), dp(14), dp(12));
        button.setBackground(rounded(PURPLE, 16));
        return button;
    }

    private Button secondaryButton(String text) {
        Button button = primaryButton(text);
        button.setTextColor(PURPLE_DARK);
        button.setBackground(rounded(PURPLE_LIGHT, 16));
        return button;
    }

    private Button optionButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextColor(TEXT);
        button.setTextSize(16);
        button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        button.setAllCaps(false);
        button.setPadding(dp(15), dp(12), dp(15), dp(12));
        styleOption(button, WHITE, Color.rgb(220, 214, 228));
        return button;
    }

    private void styleOption(Button button, int fill, int stroke) {
        GradientDrawable bg = rounded(fill, 14);
        bg.setStroke(dp(1), stroke);
        button.setBackground(bg);
    }

    private GradientDrawable rounded(int color, int radiusDp) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(color);
        bg.setCornerRadius(dp(radiusDp));
        return bg;
    }

    private LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private LinearLayout.LayoutParams wrap() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private LinearLayout.LayoutParams cardParams() {
        LinearLayout.LayoutParams params = matchWrap();
        params.topMargin = dp(12);
        params.bottomMargin = dp(8);
        return params;
    }

    private int dp(int value) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(value * density);
    }

    private String heartText() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i < lives) b.append("♥"); else b.append("♡");
            if (i < 2) b.append(" ");
        }
        return b.toString();
    }

    private String letter(int i) {
        return String.valueOf((char) ('A' + i));
    }

    private static class Challenge {
        final String world;
        final String title;
        final String prompt;
        final String[] options;
        final int correctIndex;
        final String explanation;

        Challenge(String world, String title, String prompt, String[] options, int correctIndex, String explanation) {
            this.world = world;
            this.title = title;
            this.prompt = prompt;
            this.options = options;
            this.correctIndex = correctIndex;
            this.explanation = explanation;
        }
    }
}
