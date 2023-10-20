package kr.ecocow.ecomovie.controller.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kr.ecocow.ecomovie.controller.MovieController;
import kr.ecocow.ecomovie.dto.MovieDetailsDTO;
import kr.ecocow.ecomovie.dto.MovieRecommendationResponseDTO;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MovieControllerDocs {
    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(summary = "영화 상세 페이지 조회")
    @Parameters({
            @Parameter(name = "movieId", examples = {
                    @ExampleObject(name = "예시 1", value = "1"),
                    @ExampleObject(name = "예시 2", value = "2"),
                    @ExampleObject(name = "예시 3", value = "3"),
            }),
            @Parameter(name = "request",
                    description = "<table>\n" +
                            "    <tr>\n" +
                            "        <th>필드 이름</th>\n" +
                            "        <th>타입</th>\n" +
                            "        <th>설명</th>\n" +
                            "    </tr>\n" +
                            "    <tr>\n" +
                            "        <td>&nbsp;append_to_response&nbsp;</td>\n" +
                            "        <td>&nbsp;Enum(\"recommendations\")&nbsp;</td>\n" +
                            "        <td>\n" +
                            "            &nbsp;&nbsp;문자열 Enum 타입으로 괄호 안에 있는 값을 사용 가능합니다. 사용한 항목이 응답에 포함되어 함께 전달됩니다.\n" +
                            "            recommendations를 사용할 경우 추천 영화 목록이 포함됩니다.\n" +
                            "        </td>\n" +
                            "    </tr>\n" +
                            "    <tr>\n" +
                            "        <td>&nbsp;language&nbsp;</td>\n" +
                            "        <td>&nbsp;String&nbsp;</td>\n" +
                            "        <td>\n" +
                            "            <a target=\\\"_blank\\\" href=\\\"https://developers.naver.com/docs/papago/papago-nmt-overview.md#papago-%EB%B2%88%EC%97%AD-%EA%B0%9C%EC%9A%94\\\">\n" +
                            "                번역 가능한 언어\n" +
                            "            </a>\n" +
                            "        </td>\n" +
                            "    </tr>\n" +
                            "</table>",
                    examples = {
                            @ExampleObject(name = "빈 값", value = "{}"),
                            @ExampleObject(name = "추천 영화 목록 포함", value = "{\n" +
                                    "  \"append_to_response\": \"recommendations\"\n" +
                                    "}"),
                            @ExampleObject(name = "영화 제목을 한글로 번역", value = "{\n" +
                                    "  \"language\": \"ko\"\n" +
                                    "}"),
                            @ExampleObject(name = "모든 항목 포함", value = "{\n" +
                                    "  \"append_to_response\": \"recommendations\"\n" +
                                    "  \"language\": \"ko\"\n" +
                                    "}")
                    }
            )
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "영화 상세 페이지 조회 성공 (자료형 확인 가능)",
                    content = @Content(schema = @Schema(implementation = MovieDetailsDTO.class))),
            @ApiResponse(responseCode = "200 ", description = "영화 상세 페이지 조회 성공 (with 추천 영화 목록)",
                    content = @Content(schema = @Schema(example = "{\n" +
                            "  \"id\": 2484,\n" +
                            "  \"imdb_id\": \"tt0497329\",\n" +
                            "  \"backdrop_path\": \"/eKRKdTPXzgUlDNhWF00bCz9wGM1.jpg\",\n" +
                            "  \"poster_path\": \"/7sbLeFbRxSNXHc1ZO4zxFy3sIgc.jpg\",\n" +
                            "  \"original_language\": \"en\",\n" +
                            "  \"original_title\": \"Behind Enemy Lines II: Axis of Evil\",\n" +
                            "  \"title\": \"Behind Enemy Lines II: Axis of Evil\",\n" +
                            "  \"overview\": \"Navy SEALS, headed by Lt. Bobby James, are dispatched to North Korea on a covert mission, all in an effort to take out a missile site...\",\n" +
                            "  \"vote_average\": 4.4,\n" +
                            "  \"vote_count\": 70,\n" +
                            "  \"popularity\": 9.814,\n" +
                            "  \"budget\": 0,\n" +
                            "  \"revenue\": 0,\n" +
                            "  \"runtime\": 96,\n" +
                            "  \"release_date\": \"2006-10-17\",\n" +
                            "  \"status\": \"Released\",\n" +
                            "  \"adult\": false,\n" +
                            "  \"video\": false,\n" +
                            "  \"belongs_to_collection\": {\n" +
                            "    \"id\": 685,\n" +
                            "    \"name\": \"Behind Enemy Lines Collection\",\n" +
                            "    \"poster_path\": \"/baDDWPQgZyBKiDNeipLJ9LEZ5BX.jpg\",\n" +
                            "    \"backdrop_path\": \"/5sMWk8wutGCFAM7MAFPQJyc0ny0.jpg\"\n" +
                            "  },\n" +
                            "  \"genres\": [\n" +
                            "    {\n" +
                            "      \"id\": 53,\n" +
                            "      \"name\": \"Thriller\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "      \"id\": 28,\n" +
                            "      \"name\": \"Action\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "      \"id\": 12,\n" +
                            "      \"name\": \"Adventure\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"production_companies\": [\n" +
                            "    {\n" +
                            "      \"id\": 7001,\n" +
                            "      \"logo_path\": \"/qZCc1lty5FzX30aOCVRBLzaVmcp.png\",\n" +
                            "      \"name\": \"20th Century Fox\",\n" +
                            "      \"origin_country\": \"US\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"production_countries\": [\n" +
                            "    {\n" +
                            "      \"iso_3166_1\": \"US\",\n" +
                            "      \"name\": \"United States of America\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"spoken_languages\": [\n" +
                            "    {\n" +
                            "      \"english_name\": null,\n" +
                            "      \"iso_639_1\": \"es\",\n" +
                            "      \"name\": \"Español\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "      \"english_name\": null,\n" +
                            "      \"iso_639_1\": \"ru\",\n" +
                            "      \"name\": \"Pусский\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "      \"english_name\": null,\n" +
                            "      \"iso_639_1\": \"en\",\n" +
                            "      \"name\": \"English\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"recommendations\": {\n" +
                            "    \"page\": 1,\n" +
                            "    \"results\": [\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/bLedLNwTzfDOSN6JVAOt7ykAzu7.jpg\",\n" +
                            "        \"id\": 2536,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Escape from L.A.\",\n" +
                            "        \"overview\": \"This time, a cataclysmic temblor hits Los Angeles, turning it into an island. The president views the quake as a sign from above, expels Los Angeles from the country and makes it a penal colony for those found guilty of moral crimes. When his daughter, part of a resistance movement, steals the control unit for a doomsday weapon, Snake again gets tapped to save the day.\",\n" +
                            "        \"poster_path\": \"/3L9lL2eUsmLNNfENPwNOc82Hzpw.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          878,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 18.505,\n" +
                            "        \"release_date\": \"1996-08-09\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 5.9,\n" +
                            "        \"vote_count\": 828\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/5GnJKCuLIYLgfXuTt2LeWxlcetA.jpg\",\n" +
                            "        \"id\": 2805,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Volcano\",\n" +
                            "        \"overview\": \"An earthquake shatters a peaceful Los Angeles morning and opens a fissure deep into the earth, causing lava to start bubbling up. As a volcano begins forming in the La Brea Tar Pits, the director of the city's emergency management service, Mike Roark, working with geologist Amy Barnes, must then use every resource in the city to try and stop the volcano from consuming Los Angeles.\",\n" +
                            "        \"poster_path\": \"/5xIjktjXuro7anZ6AR58t5ZYWjQ.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          878,\n" +
                            "          28,\n" +
                            "          18,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 24.161,\n" +
                            "        \"release_date\": \"1997-04-25\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 5.7,\n" +
                            "        \"vote_count\": 869\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/bdNHNvZc9fM6Cw3r7HHMCWacI9I.jpg\",\n" +
                            "        \"id\": 3178,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Quantum of Solace\",\n" +
                            "        \"overview\": \"Quantum of Solace continues the adventures of James Bond after Casino Royale. Betrayed by Vesper, the woman he loved, 007 fights the urge to make his latest mission personal. Pursuing his determination to uncover the truth, Bond and M interrogate Mr. White, who reveals that the organization that blackmailed Vesper is far more complex and dangerous than anyone had imagined.\",\n" +
                            "        \"poster_path\": \"/aSBIBTM2mLYLilRBW6XWVitXAKo.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          53,\n" +
                            "          80\n" +
                            "        ],\n" +
                            "        \"popularity\": 23.448,\n" +
                            "        \"release_date\": \"2008-10-30\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.3,\n" +
                            "        \"vote_count\": 5312\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/leHpAsKAJGnNuv5EPAUZUbqrRxq.jpg\",\n" +
                            "        \"id\": 3366,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"cn\",\n" +
                            "        \"original_title\": \"飛鷹計劃\",\n" +
                            "        \"overview\": \"Agent Jackie is hired to find WWII Nazi gold hidden in the Sahara desert. He teams up with three bungling women (the 3 stooges?) who are all connected in some way. However a team of mercenaries have ideas on the ownership of the gold. A battle / chase ensues as to who gets there first. Lots of choreographed Kung-Fu and quirky Chan humor.\",\n" +
                            "        \"poster_path\": \"/dxdFXfgoQB4ABAz2qmHq64GkVh1.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          80,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 18.748,\n" +
                            "        \"release_date\": \"1991-02-07\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 7.3,\n" +
                            "        \"vote_count\": 269\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/eWZhoFrE5UtqSxApCO76ChoGQpW.jpg\",\n" +
                            "        \"id\": 3387,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Commando\",\n" +
                            "        \"overview\": \"John Matrix, the former leader of a special commando strike force that always got the toughest jobs done, is forced back into action when his young daughter is kidnapped. To find her, Matrix has to fight his way through an array of punks, killers, one of his former commandos, and a fully equipped private army. With the help of a feisty stewardess and an old friend, Matrix has only a few hours to overcome his greatest challenge: finding his daughter before she's killed.\",\n" +
                            "        \"poster_path\": \"/ggVVcXvlLqFOK6lEkD8G2aDarDb.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 17.929,\n" +
                            "        \"release_date\": \"1985-10-03\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.6,\n" +
                            "        \"vote_count\": 1625\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/kfoV2SouW0cTYGwQA1QgWjiuxKU.jpg\",\n" +
                            "        \"id\": 3612,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Anacondas: The Hunt for the Blood Orchid\",\n" +
                            "        \"overview\": \"The blood orchid - A rare flower that holds the secret of eternal life and a fortune to the pharmaceutical company that finds it. Led by a two-fisted soldier of fortune, a scientific expedition is sent deep into the jungles of Borneo to locate and bring back samples of the legendary plant. Battling their way upriver, the explorers brave poisonous insects, ferocious crocodiles and savage headhunters, unaware they're being stalked by an even greater danger: a nest of giant anacondas, voracious, fifty-foot-long flesh-eaters who'll stop at nothing to protect their breeding ground, the blood orchid's home.\",\n" +
                            "        \"poster_path\": \"/gTlVy3wUApAanIAPdx3yz0YOROD.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          27,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 19.701,\n" +
                            "        \"release_date\": \"2004-08-26\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 5.3,\n" +
                            "        \"vote_count\": 553\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/kP8rK9dGS1pr0HrnmXfIi2heWjo.jpg\",\n" +
                            "        \"id\": 3779,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Kingdom of Heaven\",\n" +
                            "        \"overview\": \"After his wife dies, a blacksmith named Balian is thrust into royalty, political intrigue and bloody holy wars during the Crusades.\",\n" +
                            "        \"poster_path\": \"/3fQJxq26GU9a4dCQywZ6r8vgYKS.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          18,\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          36,\n" +
                            "          10752\n" +
                            "        ],\n" +
                            "        \"popularity\": 21.456,\n" +
                            "        \"release_date\": \"2005-05-03\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.8,\n" +
                            "        \"vote_count\": 2557\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/fBvSfLetWlAMevQVHa0nBDV1Fon.jpg\",\n" +
                            "        \"id\": 3819,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Die Hard: With a Vengeance\",\n" +
                            "        \"overview\": \"New York detective John McClane is back and kicking bad-guy butt in the third installment of this action-packed series, which finds him teaming with civilian Zeus Carver to prevent the loss of innocent lives. McClane thought he'd seen it all, until a genius named Simon engages McClane, his new \\\"partner\\\" -- and his beloved city -- in a deadly game that demands their concentration.\",\n" +
                            "        \"poster_path\": \"/7mBUd8Y6AhcdICaMnSV8UPtF8rc.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 20.888,\n" +
                            "        \"release_date\": \"1995-05-19\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 7.2,\n" +
                            "        \"vote_count\": 3961\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/fgkgab4Rel0nOI3B3scHeNB4Mn6.jpg\",\n" +
                            "        \"id\": 3820,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Die Hard 2\",\n" +
                            "        \"overview\": \"Off-duty cop John McClane is gripped with a feeling of déjà vu when, on a snowy Christmas Eve in the nation’s capital, terrorists seize a major international airport, holding thousands of holiday travelers hostage. Renegade military commandos led by a murderous rogue officer plot to rescue a drug lord from justice and are prepared for every contingency except one: McClane’s smart-mouthed heroics.\",\n" +
                            "        \"poster_path\": \"/ybki0UWO3OPhaM6MSniuKC7sy1R.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 23.926,\n" +
                            "        \"release_date\": \"1990-07-02\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.9,\n" +
                            "        \"vote_count\": 3626\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/nnmbJvYyDS1VkMOCbxSpdBi3WbJ.jpg\",\n" +
                            "        \"id\": 3825,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Apocalypto\",\n" +
                            "        \"overview\": \"Set in the Mayan civilization, when a man's idyllic presence is brutally disrupted by a violent invading force, he is taken on a perilous journey to a world ruled by fear and oppression where a harrowing end awaits him. Through a twist of fate and spurred by the power of his love for his woman and his family he will make a desperate break to return home and to ultimately save his way of life.\",\n" +
                            "        \"poster_path\": \"/qbOG3FpCpuYFGhAbJWsAeZ603JF.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          18,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 23.335,\n" +
                            "        \"release_date\": \"2006-12-07\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 7.5,\n" +
                            "        \"vote_count\": 3262\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/eidO9z8CjyVjD2Rs48JXjFUFR8s.jpg\",\n" +
                            "        \"id\": 3873,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Speed\",\n" +
                            "        \"overview\": \"Los Angeles SWAT cop Jack Traven is up against bomb expert Howard Payne, who's after major ransom money. First it's a rigged elevator in a very tall building. Then it's a rigged bus--if it slows, it will blow, bad enough any day, but a nightmare in LA traffic. And that's still not the end.\",\n" +
                            "        \"poster_path\": \"/Apu3Ecg11bIEEiKLnbhagGtWNg7.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          80\n" +
                            "        ],\n" +
                            "        \"popularity\": 22.647,\n" +
                            "        \"release_date\": \"1994-06-09\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 7,\n" +
                            "        \"vote_count\": 3794\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/ysYBfA0VcbJic9CURRmR1QwWaKw.jpg\",\n" +
                            "        \"id\": 3901,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"The Hunt for Red October\",\n" +
                            "        \"overview\": \"A new, technologically-superior Soviet sub, the Red October, is heading for the U.S. coast under the command of Captain Marko Ramius. The American government thinks Ramius is planning to attack. A lone CIA analyst has a different idea: he thinks Ramius is planning to defect, but he has only a few hours to find him and prove it — because the entire Russian naval and air commands are trying to find him, too.\",\n" +
                            "        \"poster_path\": \"/yVl7zidse4KiWtGMqHFtZCx4X3N.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 15.729,\n" +
                            "        \"release_date\": \"1990-03-02\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 7.4,\n" +
                            "        \"vote_count\": 1889\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/azIbQpeKKNF9r85lBSRrNnMK0Si.jpg\",\n" +
                            "        \"id\": 4056,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"The Empire Strikes Back\",\n" +
                            "        \"overview\": \"The epic saga continues as Luke Skywalker, in hopes of defeating the evil Galactic Empire, learns the ways of the Jedi from aging master Yoda. But Darth Vader is more determined than ever to capture Luke. Meanwhile, rebel leader Princess Leia, cocky Han Solo, Chewbacca, and droids C-3PO and R2-D2 are thrown into various stages of capture, betrayal and despair.\",\n" +
                            "        \"poster_path\": \"/7BuH8itoSrLExs2YZSsM01Qk2no.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          878\n" +
                            "        ],\n" +
                            "        \"popularity\": 28.07,\n" +
                            "        \"release_date\": \"1980-05-20\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 8.4,\n" +
                            "        \"vote_count\": 11723\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/soJdiy91Mcyj29GzEgZ5svFcuZg.jpg\",\n" +
                            "        \"id\": 4057,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Return of the Jedi\",\n" +
                            "        \"overview\": \"Luke Skywalker leads a mission to rescue his friend Han Solo from the clutches of Jabba the Hutt, while the Emperor seeks to destroy the Rebellion once and for all with a second dreaded Death Star.\",\n" +
                            "        \"poster_path\": \"/mDCBQNhR6R0PVFucJl0O4Hp5klZ.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          878\n" +
                            "        ],\n" +
                            "        \"popularity\": 17.316,\n" +
                            "        \"release_date\": \"1983-05-25\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 8,\n" +
                            "        \"vote_count\": 9784\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/aTXhYyxx23AGWAqrkrs1fNGhgSO.jpg\",\n" +
                            "        \"id\": 4058,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Star Wars: Episode I - The Phantom Menace\",\n" +
                            "        \"overview\": \"Anakin Skywalker, a young slave strong with the Force, is discovered on Tatooine. Meanwhile, the evil Sith have returned, enacting their plot for revenge against the Jedi.\",\n" +
                            "        \"poster_path\": \"/6wkfovpn7Eq8dYNKaG5PY3q2oq6.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          878\n" +
                            "        ],\n" +
                            "        \"popularity\": 20.329,\n" +
                            "        \"release_date\": \"1999-05-19\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.5,\n" +
                            "        \"vote_count\": 9837\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/qy9tIZIglHxq4wH796SHpCYy3cm.jpg\",\n" +
                            "        \"id\": 4132,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Fantastic Four: Rise of the Silver Surfer\",\n" +
                            "        \"overview\": \"The Fantastic Four return to the big screen as a new and all powerful enemy threatens the Earth. The seemingly unstoppable 'Silver Surfer', but all is not what it seems and there are old and new enemies that pose a greater threat than the intrepid superheroes realize.\",\n" +
                            "        \"poster_path\": \"/av1QVSc8BWpk1WrSKLRhnbqTjX0.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          14,\n" +
                            "          28,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 18.059,\n" +
                            "        \"release_date\": \"2007-06-13\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 5.5,\n" +
                            "        \"vote_count\": 5685\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/qa0R8LCis5t8WCURDOmxC75WWRh.jpg\",\n" +
                            "        \"id\": 4145,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Lara Croft: Tomb Raider\",\n" +
                            "        \"overview\": \"English aristocrat Lara Croft is skilled in hand-to-hand combat and in the middle of a battle with a secret society. The shapely archaeologist moonlights as a tomb raider to recover lost antiquities and meets her match in the evil Powell, who's in search of a powerful relic.\",\n" +
                            "        \"poster_path\": \"/sJpl1EfHGZhbKtZ3fWTlwrpM1tH.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          14,\n" +
                            "          28,\n" +
                            "          53\n" +
                            "        ],\n" +
                            "        \"popularity\": 26.386,\n" +
                            "        \"release_date\": \"2001-06-11\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 5.9,\n" +
                            "        \"vote_count\": 4388\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/oSA2dPUhF3y1rlTG9CDgaqN0vYQ.jpg\",\n" +
                            "        \"id\": 4169,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"Hard Target\",\n" +
                            "        \"overview\": \"When a woman's father goes missing, she enlists a local to aid in her search.  The pair soon discover that her father has died at the hands of a wealthy sportsman who hunts homeless men as a form of recreation.\",\n" +
                            "        \"poster_path\": \"/x9HfOKWAB506jJVWo0z848SKDML.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          28,\n" +
                            "          12,\n" +
                            "          80,\n" +
                            "          53,\n" +
                            "          18\n" +
                            "        ],\n" +
                            "        \"popularity\": 23.734,\n" +
                            "        \"release_date\": \"1993-08-20\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.2,\n" +
                            "        \"vote_count\": 543\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/2kOgnTByORg6gvEWWy8ynyJpCXa.jpg\",\n" +
                            "        \"id\": 4202,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"National Treasure\",\n" +
                            "        \"overview\": \"Modern treasure hunters, led by archaeologist Ben Gates, search for a chest of riches rumored to have been stashed away by George Washington, Thomas Jefferson and Benjamin Franklin during the Revolutionary War. The chest's whereabouts may lie in secret clues embedded in the Constitution and the Declaration of Independence, and Gates is in a race to find the gold before his enemies do.\",\n" +
                            "        \"poster_path\": \"/20MSnfTICmwvAs2YJTqcSTjwBDc.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          53,\n" +
                            "          9648\n" +
                            "        ],\n" +
                            "        \"popularity\": 22.204,\n" +
                            "        \"release_date\": \"2004-11-19\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 6.5,\n" +
                            "        \"vote_count\": 4287\n" +
                            "      },\n" +
                            "      {\n" +
                            "        \"adult\": false,\n" +
                            "        \"backdrop_path\": \"/aPB3jFuMSoNFk2uDZ5tX5CIGaSX.jpg\",\n" +
                            "        \"id\": 4621,\n" +
                            "        \"title\": null,\n" +
                            "        \"original_language\": \"en\",\n" +
                            "        \"original_title\": \"The Abyss\",\n" +
                            "        \"overview\": \"A civilian oil rig crew is recruited to conduct a search and rescue effort when a nuclear submarine mysteriously sinks. One diver soon finds himself on a spectacular odyssey 25,000 feet below the ocean's surface where he confronts a mysterious force that has the power to change the world or destroy it.\",\n" +
                            "        \"poster_path\": \"/jel2BuDv7Bq4fuv2pUrTfiBm69o.jpg\",\n" +
                            "        \"media_type\": \"movie\",\n" +
                            "        \"genre_ids\": [\n" +
                            "          12,\n" +
                            "          28,\n" +
                            "          53,\n" +
                            "          878\n" +
                            "        ],\n" +
                            "        \"popularity\": 18.519,\n" +
                            "        \"release_date\": \"1989-08-09\",\n" +
                            "        \"video\": false,\n" +
                            "        \"vote_average\": 7.3,\n" +
                            "        \"vote_count\": 1677\n" +
                            "      }\n" +
                            "    ],\n" +
                            "    \"total_pages\": 5,\n" +
                            "    \"total_results\": 99\n" +
                            "  }\n" +
                            "}"))),
            @ApiResponse(responseCode = "200  ", description = "영화 상세 페이지 조회 성공 (with 영화 제목 번역)",
                    content = @Content(schema = @Schema(example = "{\n" +
                            "  \"id\": 2479,\n" +
                            "  \"imdb_id\": \"tt0109747\",\n" +
                            "  \"backdrop_path\": null,\n" +
                            "  \"poster_path\": \"/jf2SxLhiEeAwpYPaM8NWezJhAWF.jpg\",\n" +
                            "  \"original_language\": \"es\",\n" +
                            "  \"original_title\": \"La estrategia del caracol\",\n" +
                            "  \"title\": \"달팽이 전략\",\n" +
                            "  \"overview\": \"A group of tenants living in an old house are confronted with having to move out due to a renovation project the city has undertaken. The tenants decide to unite and come up with a strategy, but in the process—while the landlord and his aggressive attorney are chasing them—the tenants transform into the opposite of who they once were.\",\n" +
                            "  \"vote_average\": 7.1,\n" +
                            "  \"vote_count\": 35,\n" +
                            "  \"popularity\": 2.968,\n" +
                            "  \"budget\": 0,\n" +
                            "  \"revenue\": 0,\n" +
                            "  \"runtime\": 116,\n" +
                            "  \"release_date\": \"1993-12-25\",\n" +
                            "  \"status\": \"Released\",\n" +
                            "  \"adult\": false,\n" +
                            "  \"video\": false,\n" +
                            "  \"belongs_to_collection\": null,\n" +
                            "  \"genres\": [\n" +
                            "    {\n" +
                            "      \"id\": 35,\n" +
                            "      \"name\": \"Comedy\"\n" +
                            "    },\n" +
                            "    {\n" +
                            "      \"id\": 18,\n" +
                            "      \"name\": \"Drama\"\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"production_companies\": [\n" +
                            "    {\n" +
                            "      \"id\": 4617,\n" +
                            "      \"logo_path\": null,\n" +
                            "      \"name\": \"Ministère de la Culture et de la Francophonie\",\n" +
                            "      \"origin_country\": null\n" +
                            "    },\n" +
                            "    {\n" +
                            "      \"id\": 4618,\n" +
                            "      \"logo_path\": null,\n" +
                            "      \"name\": \"Ministère des Affaires Étrangères\",\n" +
                            "      \"origin_country\": null\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"production_countries\": [],\n" +
                            "  \"spoken_languages\": [\n" +
                            "    {\n" +
                            "      \"english_name\": null,\n" +
                            "      \"iso_639_1\": \"es\",\n" +
                            "      \"name\": \"Español\"\n" +
                            "    }\n" +
                            "  ]\n" +
                            "}"))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 영화",
                    content = @Content(schema = @Schema(example = MovieController.MOVIE_NOT_FOUND_MESSAGE)))
    })
    public @interface GetMovieDetails { }

    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Operation(summary = "추천 영화 목록 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "추천 영화 목록 조회 성공",
                    content = @Content(schema = @Schema(implementation = MovieRecommendationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 영화",
                    content = @Content(schema = @Schema(example = MovieController.MOVIE_NOT_FOUND_MESSAGE)))
    })
    public @interface GetMovieRecommendations { }
}
