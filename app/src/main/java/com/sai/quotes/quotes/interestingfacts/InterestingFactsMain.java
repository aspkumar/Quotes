package com.sai.quotes.quotes.interestingfacts;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sai.quotes.quotes.R;

import java.util.ArrayList;

/**
 * Created by PrasannakumarA on 5/19/2017.
 */

public class InterestingFactsMain extends AppCompatActivity {
    ArrayList<InterestingFactsPOJO> headandbody;
    RecyclerView mRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interestingfacts);
        headandbody = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Interesting Facts");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        headandbody.add(new InterestingFactsPOJO("Master of Concentration", "Narendra was a master storyteller whose words" +
                "were as magnetic as his personality. When he spoke" +
                "everyone listened with rapt attention forgetting their" +
                "work. One day while in school, Narendra was talking" +
                "animatedly to his friends during a class recess." +
                "Meanwhile, the teacher had entered the classroom" +
                "and had begun to teach his subject. But the students" +
                "were too absorbed in Narendra's story to pay any" +
                "attention to the lesson. After some time had passed," +
                "the teacher heard the whispering and understood what" +
                "was going on! Visibly annoyed, he now asked each" +
                "student what he had been lecturing on. None could" +
                "answer. But Narendra was remarkably talented; his" +
                "mind could work simultaneously on two planes." +
                "While he had engaged one part of his mind in talking," +
                "he had-kept the other half on the lesson. So when the" +
                "teacher asked him that question, he answered" +
                "correctly. Quite nonplussed, the teacher inquired who" +
                "had been talking so long. Everybody pointed at" +
                "Narendranath, but the teacher refused to believe them." +
                "He then asked all students except Narendra to stand" +
                "up on the bench. Narendra also joined his friends and" +
                "stood up. The teacher asked him to sit down. But" +
                "Narendra replied : 'No sir, I must also stand up because" +
                "it was I who was talking to them.'"));
        headandbody.add(new InterestingFactsPOJO("Helping his friend to pay examination fee", "It was time to deposit fees for the BA examination." +
                "All the classmates of Narendra except Haridas" + "Chattopadhyaya had deposited th£ money. Haridas was" +
                "very poor. He could somehow manage to gather the" +
                "examination fees but the college authorities would not" +
                "accept them unless he paid his college dues for the" +
                "whole year. Thus Haridas's hope of sitting for the" +
                "examination was dashed to the ground." +
                "Narendranath eventually came to know about the" +
                "plight of Haridas and was shocked. Suddenly it dawned" +
                "on him that there was a provision for exemption from" +
                "college dues in special cases, and that Rajkumarbabu," +
                "the old college clerk, could save Haridas in this crisisn" +
                "There was at least a ray of hope. So Narendra assured" +
                "his friend that he would do everything in his capacity tn" +
                "help him." +
                "A few days later when the students were depositing" +
                "their dues and examination fees, Narendra went to" +
                "Rajkumarbabu and pleaded, 'Sir, Haridas is incapable" +
                "of paying his college dues. Will you kindly exempt him?" +
                "If you send him up for the examination he will pass with" +
                "credit; otherwise he will be undone.'" +
                "Rajkumarbabu had an irritable temper. He grimaced" +
                "and carped at Narendra, 'Your presumptuous" +
                "recommendation is uncalled for. You better oil your own" +
                "machine. I won't send him up unless he pays his dues.'" +
                "Thus rebuffed Narendra became very worried about his" +
                "friend. He felt hopeless because he knew that he himself" +
                "could never collect that amount of money, and it had to" +
                "be paid immediately. Thus he was at a loss, not knowing" +
                "what to do. At this point a plan occurred to him." +
                "He knew that Rajkumarbabu was an opium-addict" +
                "and that every evening he visited a particular den" +
                "adjacent to Hedua to indulge in this habit. Narendra did" +
                "not return home after college hours that day but eagerly" +
                "waited for sundown. As darkness enveloped the city," +
                "Narendranath moved close to the den and kept" +
                "watching those going towards it. After some time" +
                "Narendranath noticed that old Rajkumar was stealthily" +
                "inching towards the opium shops. Realizing that the fish" +
                "was now in his net, Narendranath hurriedly appeared" +
                "before Rajkumarbabu, who was of course embarrassed." +
                "Narendranath realized that this was the opportune" +
                "moment. He once again pleaded for Haridas and" +
                "threatened that he would let the cat out of the bag if" +
                "Rajkumarbabu failed to comply with his request." +
                "Rajkumarbabu smelt danger, so he said to Narendra" +
                "in a low voice, 'Why do you get angry with me, dear?" +
                "What you want will be done. Can I ever ignore your" +
                "request?' Narendranath understood his job was over" +
                "and his mission was successful, so he returned home as" +
                "the old man slipped into the narcotic den." +
                "Before daybreak the following day, Narendranath" +
                "went to Haridas's house and said to him, 'Come, be of" +
                "good cheer, our work is done. You will not have to pay" +
                "the college dues.' Then Narendra described vividly what" +
                "had happened the previous evening and both of them" +
                "burst into laughter."));
        headandbody.add(new InterestingFactsPOJO("Facing the Monkeys", "The following incident took place during Swamiji's" +
                "wandering days when he was staying at Varanasi. One" +
                "day when he was returning from visiting the Durga" +
                "temple, a troop of monkeys chased after him. To save" +
                "himself Swamiji at first started running, but the monkeys" +
                "ran still faster and grew increasingly aggressive. At this" +
                "time an old monk who happened-to witness the scene" +
                "called out to him : 'Stop running. Face the brutes!'" +
                "Swamiji heard his call and turned to 'face the brutes'." +
                "Then the monkeys stopped harassing him.\n" +
                "Swamiji drew a great lesson from this apparently" +
                "simple incident. He learnt that one should not run away" +
                "when faced with danger or difficulty; instead, one must" +
                "face it boldly. In his later life, Swamiji referred to this" +
                "incident while addressing a gathering in New York. He" +
                "said : 'That is a lesson for all life—face the terrible, face" +
                "it boldly. Like the monkeys, the hardships of life fall" +
                "back when we cease to flee before them. If we are ever" +
                "to gain freedom, it must be by conquering nature, never" +
                "by running away. Cowards never win victories. We have" +
                "to face fear and troubles and ignorance if we expect" +
                "them to flee before us.'"));
        headandbody.add(new InterestingFactsPOJO("Reading speed and memory power of vivekananda", "An interesting incident took place when Swami" +
                "Vivekananda was living the life of a wandering monk." +
                "It was most probably in the second week of November" +
                "1890 that Swamiji came to Meerut where by chance he" +
                "met some of his brother monks who were also on" +
                "pilgrimage. All of them were naturally very pleased to" +
                "see one another after such a long time. They lived" +
                "together and transformed the place into a second" +
                "Baranagore Math.\n" +
                "It is well known that Swamiji w^s a great lover of" +
                "books. In Meerut, he spent much time in reading. At his" +
                "bidding Swami Akhandananda would go to a local" +
                "library every day and bring a big volume of Sir John" +
                "Lubbock's works and return it the following day.\n" +
                "The librarian thought that Swamiji was not reading" +
                "the books, that he was only trying to impress everyone." +
                "One day the librarian openly expressed his doubt to" +
                "Swami Akhandananda when the latter came to collect" +
                "another volume of Lubbock. Akhandananda reported" +
                "this to Swamiji, On hearing this Swamiji himself one day" +
                "called on the librarian and said to him humbly, 'Sir, I" +
                "have gone through the books attentively, and if you have" +
                "any doubt about it, you may ask any question you like" +
                "from the books.' The librarian then asked a number of" +
                "questions and Swamiji correctly answered them. The" +
                "librarian was astonished. Never before had he seen such" +
                "a person as Swamiji!\n" +
                "The Raja of Khttri was equally amazed by" +
                "Swamiji's mode of reading. Swamiji would simply" +
                "turn over the pages of a book quite hurriedly from" +
                "beginning to the end, and that was all—the book had" +
                "been read! When the Raja asked how that was possible," +
                "Swamiji explained that when a child first learns to read" +
                "he fixes his attention on a particular letter of the" +
                "alphabet, pronounces it twice or thrice, and then moves" +
                "on to the next letter to utter the whole word. As he" +
                "masters the art of reading a little, he keeps his attention" +
                "on each word. After much practice he can read a" +
                "sentence at a glance. If one goes on increasing his power" +
                "of concentration, one can read a page in the twinkling of" +
                "an eye. Swamiji said that was exactly what he did and" +
                "added that three things were necessary—continence," +
                "practice, and concentration. Anybody could achieve this" +
                "power if he scrupulously adhered to these three things.\n" +
                "Once he astonished Haripada Mitra, the Subdivisional" +
                "Forest Officer of Belgaum, by reciting from" +
                "memory a large portion of Dickens's Pickwick Paper.?." +
                "Haripadababu was more wonder-struck when Swamiji" +
                "22 Swami Vivekananda : The Friend of All" +
                "told him that he had read the book only twice. He told" +
                "Mitra that concentration and continence sharpen the" +
                "mind.\n" +
                "Swamiji was once unwell and staying at Belur Math." +
                "One day his disciple Sharatchandra Chakravarti came to" +
                "see him in his room and found there a new set of the" +
                "Encyclopaedia Britannica. Sharatchandra looked at" +
                "• those large glossy volumes and remarked, 'It is indeed" +
                "very difficult to read so many volumes in one lifetime.'" +
                "Swamiji did not agree. 'What do you mean?' he said," +
                "'Ask me anything you like from the ten volumes I have" +
                "just finished.'\n" +
                "The disciple asked Swamiji a number of questions" +
                "from each volume and, to his wonder, Swamiji passed" +
                "the test. Not only that, in many cases, Swamiji quoted at" +
                "length the very words of the books. At last, to instil selfconfidence" +
                "in his disciple, Swamiji said, 'Look my child," +
                "if you can observe strict continence, you can master" +
                "everything you wish and can easily acquire this kind of" +
                "memory.' Swamiji said the same thing to the German" +
                "philosopher Paul Deussen who was astonished by his" +
                "prodigious memory."));
        headandbody.add(new InterestingFactsPOJO("with King of Alwar on Idol Worshiping", "Once Swami Vivekananda visited King of Alwar in present day Rajasthan. The king in an attempt to mock idol worship told Swamiji, \"I've no faith in idol worship. How can one worship stone, wood and metal? I believe people are in illusion and just wasting time!\". \n" +
                "Swamiji smiled. He asked the king's assistant to take down the picture of the king that was hanging on the wall. Although confused, the assistant did so. Then Swamiji ordered him, \"Spit on the picture!\". The assistant was shocked and looked at both of them. Swami repeated again and again, becoming more stern each time. The king was growing angry and the assistant started trembling. Finally, he cried out, \"How can I spit on this? This picture is of our beloved and respected king!\".\n" +
                "Swamiji then told him, \"The king is sitting in front of you in person. This picture is merely a paper - it does not speak, hear, think or move. But still you did not spit because you see a shadow of your king in it, Spitting on it was like spitting on the king itself.\" The king looked at Swamiji and bowed down, clearly understanding what he was referring to.\n" +
                "\n" +
                "This is the essence of idol worshiping. God is everywhere, but people want to pray to Him, ask favors, offer food, tell stories, bathe Him, play with Him and do what they do in their lives. Creating a human-like idol creates an image of God as a companion, a guide, a friend, a protector, a giver, a fellow being and so on. An idol is just a concrete representation where they find Him. When I look into the eyes of an idol, I do not see stone or metal, but another pair of eyes looking affectionately at me, smiling."));

        headandbody.add(new InterestingFactsPOJO("Meeting with Rockefeller ","Mr\n" +
                "Rockefeller had heard from his friends about Swamiji.\n" +
                "They wanted him to meet the extraordinary Indian\n" +
                "monk, but on one pretext or another, he refused. He\n" +
                "was very strong-willed and it was difficult for anyone to\n" +
                "change his decision. But one day, on an impulse,\n" +
                "Rockefeller went to the house of a friend in Chicago\n" +
                "where Swamiji was staying. Brushing aside the butler\n" +
                "who opened the door, he demanded to see the Hindu\n" +
                "monk.\n" +
                "The butler ushered him into the living room, and not\n" +
                "waiting to be announced, Rockefeller entered Swamiji's\n" +
                "adjoining study. He was greatly surprised to see Swamiji\n" +
                "seated at his writing table not even lifting his eyes to see\n" +
                "who had entered. After a while, as with Calve, Swamiji\n" +
                "told Rockefeller much about his past that was not\n" +
                "known to anyone but himself, and made him understand\n" +
                "that the money he had already accumulated was not his,\n" +
                "that he was only a channel and that his duty was to do\n" +
                "good to the world—that God had given him his wealth\n" +
                "in order that he might have an opportunity to help\n" +
                "people. Rockefeller was annoyed that anyone dared to\n" +
                "talk to him that way. He left the room in irritation, not\n" +
                "even saying goodbye. But about a week later, again\n" +
                "without being announced, he entered Swamiji's study\n" +
                "and finding him the same as before, threw on his desk a\n" +
                "paper which told of his plans to donate an enormous\n" +
                "sum of money toward the financing of a public institution.\n" +
                "'Well, there you are,' he said, 'you must be satisfied\n" +
                "now, and you can thank me for it!' Swamiji didn't even\n" +
                "lift his eyes, didn't move. Then taking the paper, he\n" +
                "quietly read it and said, 'It is for you to thank me.'\n" +
                "This was Rockefeller's first large donation to the\n" +
                "cause of public welfare. Later he became widely known\n" +
                "for his philanthropy."));
        headandbody.add(new InterestingFactsPOJO("Shooting Egg Shells","An interesting thing happened when Swamiji went to\n" +
                "the United States for the second time. One day when he\n" +
                "was walking along the bank of a river, he found a gioup\n" +
                "of youngsters shooting at a string of eggshells bobbing\n" +
                "up on the water. The youths tried in turn, but none could\n" +
                "hit the target. Swamiji, who was watching all this, felt\n" +
                "amused. He could not suppress his smile and this did not\n" +
                "escape the attention of one of the young men who said in\n" +
                "a challenging tone : 'The task is not as easy as it looks,\n" +
                "sir. Let us see how you do it!'\n" +
                "Swamiji said nothing, but took the gun from the\n" +
                "boy's hand and hit twelve shells in succession. The\n" +
                "youths were awestruck and supposed Swamiji was a\n" +
                "brilliant marksman. Swamiji could read their minds. He\n" +
                "told them he had never in his life fired a shot before and\n" +
                "that the secret of his success was concentration."));
        headandbody.add(new InterestingFactsPOJO("Meeting with J.N Tata","The story goes that Jamshedji Nusserwanji Tata was once, travelling to Germany (This excerpt is taken from the writings of Mr. Mohan Guruswamy). As he stood there, at the door of his First Class Cabin in the Steam-liner, he noticed a lot of activity on the lower decks of the Ship. On enquiring, he learnt that a great Indian Saint Shri Swami Vivekananda was on board the same ship.\n" +
                "\n" +
                "Out of genuine respect and curiosity J.N. Tata decided to pay a visit to the great saint. Swami Vivekananda had of-course heard about the respected industrialist. As the conversation grew J.N. Tata explained that he was on his way to Germany.\n" +
                "\n" +
                "“I have with me sacks of soil : From various parts of India. I am taking these samples of soil to Germany. I wish to know IF Iron can be extracted profitably from any of these districts.” said J.N. Tata to the Saint.\n" +
                "\n" +
                "To which Swami Vivekananda replied, “Well, Sir, Even IF these sacks contain Iron-rich soil, do you honestly believe that the Germans will tell you the TRUTH??? You must understand that No / NONE of the European Nations wish to see a Strong / Steel-Rich / Economically Independent India. The soil is probably rich in Iron-ore but the sad truth is all you will get from your enquiries across Europe is Disbelief and Pessimistic reactions.”\n" +
                "\n" +
                "Needless to say, having interacted with several Europeans J.N. Tata knew this to be true. Swami Vivekananda continued, “Why don’t you start an excellent / up-to-date Research Facility and College here in India??? Why don’t you train some good Indian Youngsters to identify soil and conduct these tests and find ways of profitably extracting metals??? It may seem like a wasteful; burdensome expenditure right now, but in the long run- It will save you many trips to Europe and you can have the assurance of knowing the Truth quickly- rather than taking multiple opinions due to Doubt”.\n" +
                "\n" +
                "As he could clearly sense J.N. Tata’s mood was in acquiescence he further elaborated, “Seek an audience with the Maharaja of Mysore Shri Krishnaraja Wodeyar IV.Though a subordinate of the British, he will definitely help you in every way he can. H.R.H. Wodeyar has been generous enough to sponsor my own trip to Chicago to attend the Parliament of Religions.\n" +
                "\n" +
                "By the by this is the story of the finest Education Institute of India, The Indian Institute of Science (IISc) , Bangalore commonly known as the Tata institute.\n" +
                "23k Views · 2,666 Upvotes · View Timeline\n"));

        headandbody.add(new InterestingFactsPOJO("with a White Professor","Once, a white professor, whose last name was Peters, disliked him intensely.\n" +
                "\n" +
                "One day, Mr. Peters was having lunch at the dining room when vivekananda came along with his tray and sat next to the professor.\n" +
                "\n" +
                "The professor said, \"Mr Vivekananda , you do not understand. A pig and a bird do not sit together to eat.\" Vivekanandji looked at him as a parent would a rude child and calmly replied, \"You do not worry professor. I'll fly away,\" and he went and sat at another table.\n" +
                "\n" +
                "Mr. Peters, reddened with rage, decided to take revenge.\n" +
                "\n" +
                "The next day in Class he posed the following question: \"Mr.Vivekanand , if you were walking down the street and found a package, and within was a bag of wisdom and another bag with money, which one would you take ?\"\n" +
                "\n" +
                "Without hesitating, Vivekanandji responded, \"The one with the money, of course.\"\n" +
                "\n" +
                "Mr. Peters , smiling sarcastically said, \"I, in your place, would have taken the wisdom.\"\n" +
                "\n" +
                "Swami Vivekanand shrugged and responded, \"Each one takes what he doesn't have.\"\n" +
                "\n" +
                "Mr. Peters, by this time was fit to be tied. So great was his anger that he wrote on Swami Vivekanand's exam sheet the word \"idiot\" and gave it to Swami Vivekanand . Vivekanandji took the exam sheet and sat down at his desk\n" +
                "\n" +
                "A few minutes later, Swami Vivekanand got up, went to the professor and told him in a dignified polite tone, \"Mr. Peters, you signed the sheet, but you did not give me the grade.”"));
        headandbody.add(new InterestingFactsPOJO("Presence of Mind","Once Swami Vivekananda was traveling in a train in US, and as usual happened to be in his dhoti and attire. 3 girls were making fun of him and his dressing sense, and they also saw the expensive watch gifted by an Indian king to Swamiji and then they thought to prank him.\n" +
                "\n" +
                "So they told him to give them his watch or they will complain to cops that he was physically harrassing the girls, then Swamiji did a gesture through his hands and convinced them that he was deaf so they better give in the writing. As the girls gave the same thing in the writing Swamiji spoked now you can call the cops as I have a complaint to register."));
        headandbody.add(new InterestingFactsPOJO("Black Dot with White Paper","Once Swami Vivekananda had a lecture to deliver at a college. So he wanted to give the lecture an interesting and inspiring start.\n" +
                "\n" +
                "So he took out a white sheet of paper and put it on the canvas and asked the students, “What do you see?”\n" +
                "The students replied, “White Paper.”\n" +
                "\n" +
                "He then took a black pen and drew a black dot at the centre of the white sheet, and again asked the same question.\n" +
                "The answer came: A Black Dot.\n" +
                "\n" +
                "He then explained that how easily it is to forget one’s all good deeds that he/she has done in his/her life, which was represented by the white sheet and resembled the good character of a person. The black dot resembled the bad deeds or immoral acts that a person does, which are the only things that the world sees afterwards.\n" +
                "\n" +
                "So, irrespective of how good the person is, if does things that are not right, they leave a mark on his character for a lifetime. So, it is of utmost importance to have a clean character."));
        headandbody.add(new InterestingFactsPOJO("Other Incidents","1. Before going to america, swami went to meet his guru's wife- Sharadadevi.\n" +
                "He considered her like his mother and sought blessing from her for his journey to America.\n" +
                "Sharadadevi asked him to give him the knife. \n" +
                "Swami gave one.\n" +
                "Sharadadevi smiled and said, \" you are going to be successful in your voyage, my son. When I asked you to handover the knife, you kept the handle to my side and the edge to yours.\n" +
                "This shows your compassion and care for others. You're someone who help other by suffering yourself.\""
                +"\n"
        +"2. Once a British asked Swami Vivekananda -\n" +
                "\" Why can't you wear proper clothes to look like a gentleman?\"\n" +
                "Swami Vivekananda smiled and said-\n" +
                "\" In your culture, a tailor makes a gentleman; but, in our culture, Character makes gentleman.\"\n"
        +"3. Before he left London, one of his British friends put\n" +
                "this question to him : 'Swami, how do you like now your\n" +
                "motherland after four years' experience of the luxurious,\n" +
                "glorious, powerful West?' Swamiji said : 'India I loved\n" +
                "before I came away. Now the very dust of India has\n" +
                "become holy to me, the very air is now to me holy; it is\n" +
                "now the holy land, the place of pilgrimage, the Tritha"));


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_interestingfacts);
        IFRecyclerView adapter = new IFRecyclerView(getApplicationContext(), headandbody);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setBackgroundResource(R.drawable.paragraphbg);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
