package laurent.benard.javaforandroid;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    //Scores des joueurs par défaut
    int scoreJ1;
    int scoreJ2;

    //Rendre les variables globales
    Button joueur1;
    Button joueur2;

    ImageView back;


    Button reset;

    TextView score1;
    TextView score2;

    //Reset le jeu automatiquement
    boolean gameWorking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Instructions du jeu
        TextView title = findViewById(R.id.titre);

        // Image
        ImageView img = findViewById(R.id.duel);

        // Boutons des joueurs
        joueur1 = findViewById(R.id.joueur1);
        joueur2 = findViewById(R.id.joueur2);
        // Bouton Back
        back = findViewById(R.id.Back);

        // Bouton reset
        reset = findViewById(R.id.reset);

        //Affichage des scores
        score1 = findViewById(R.id.j1Score);
        score2 = findViewById(R.id.j2Score);

        //Au click
        joueur1.setOnClickListener(this);
        joueur2.setOnClickListener(this);
        reset.setOnClickListener(this);
        back.setOnClickListener(this);

        //Démarrer la partie à zéro
        resetGame();


    }

    public void resetGame(){

        gameWorking = true;

        scoreJ1 = 0;
        scoreJ2 = 0;

        score1.setText("Le score est : " + scoreJ1);
        score2.setText("Le score est : " + scoreJ2);

        //Message toast
        Toast.makeText(this, "Commencez à jouer !", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id){

            case R.id.Back:
                GameActivity.this.finish();

                break;

            case R.id.joueur1:
                //Au click sur joueur1
                if (gameWorking){

                    scoreJ1++;
                    score1.setText("Le score est : " + scoreJ1);

                    if (scoreJ1 == 10){

                        Toast.makeText(GameActivity.this, "Joueur 1 gagne, Bravo !", Toast.LENGTH_SHORT).show();
                        gameWorking = false;
                    }

                }

                break;
            case R.id.joueur2:
                //Au click sur joueur2
                if (gameWorking){

                    scoreJ2++;
                    score2.setText("Le score est : " + scoreJ2);

                    if (scoreJ2 == 10){

                        Toast.makeText(GameActivity.this, "Joueur 2 gagne, Bravo !", Toast.LENGTH_SHORT).show();
                        gameWorking = false;
                    }

                }

                break;
            case R.id.reset:
                //Au click sur reset
                resetGame();
                break;

        }

    }



}
