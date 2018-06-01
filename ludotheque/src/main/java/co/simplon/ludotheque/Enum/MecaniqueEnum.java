package co.simplon.ludotheque.Enum;

public enum MecaniqueEnum {
	ADRESSE("Adresse"),
	AFFRONTEMENT_ESCARMOUCHE("Affrontement / escarmouche"),
	ASYMETRIQUE("Asymétrique"),
	BAG_BUILDING("Bag-building"),
	BLUFF("Bluff"),
	CHANT("Chant"),
	COMBINAISON("Combinaison"),
	COMMERCE("Commerce"),
	CONNAISSANCES("Connaissances"),
	CONNECTION("Connection"),
	CONTROLE_DE_TERRITOIRE("Contrôle de territoire"),
	COOPERATIF("Coopératif"),
	COURSE("Course"),
	DANS_TA_FACE("Dans ta face"),
	DECK_BUILDING("Deck-building"),
	DIPLOMATIE("Diplomatie"),
	DRAFT("Draft"),
	ENCHERES("Enchères"),
	EQUILIBRE("Equilibre"),
	EXPLORATION_DE_DONJON("Exploration de donjon"),
	GESTION_DE_RESSOURCES("Gestion de ressources"),
	GESTION_DU_TEMPS("Gestion du temps"),
	GUESSING("Guessing"),
	IMAGINATION("Imagination"),
	IMPROVISATION("Improvisation"),
	JEU_DE_DES("Jeu de dés"),
	MAJORITE("Majorité"),
	MEMOIRE("Mémoire"),
	OBJECTIFS_SECRETS("Objectifs secrets"),
	OBSERVATION("Observation"),
	OLNI("Objet Ludique Non Identifié"),
	PICK_UP_AND_DELIVER("Pick up & deliver"),
	PIERRE_FEUILLE_CISEAU("Pierre-Feuille-Ciseau"),
	PLIAGE("Pliage"),
	PLIS("Plis"),
	POSE_D_OUVRIERS("Pose d'ouvriers"),
	POSE_DE_TUILES("Pose de tuiles"),
	PROGRAMMATION("Programmation"),
	RAPIDITE("Rapidité"),
	ROLES_CACHES("Rôles cachés"),
	ROLL_AND_DRAW("Roll & draw"),
	SEMI_COOPERATIF("Semi-coopératif"),
	SIMULTANE("Simultané"),
	STOP_OU_ENCORE("Stop ou encore"),
	STRATEGIE("Stratégie"),
	TEMPS_LIMITE("Temps limité"),
	VOTE("Vote");


	private String text;
	
	private MecaniqueEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
