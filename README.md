# Genetic Algorithms

Special assignment 3 for AI course at [ITBA](https://www.itba.edu.ar)

## Building

This framework uses [maven](https://maven.apache.org). To build it:

``` bash
$ git clone https://github.com/lmarzora/SIA-TP3.git master
$ cd SIA-TP3/
$ mvn clean package
$ java -jar target/sia-tp3-1.0-SNAPSHOT-jar-with-dependencies.jar [-config]
```

## Config File

This repo comes with a default configuration file `default.properties`. You can supply your own by using the `-config` key when running the program.

### Global

| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Gear Data |  global.data | test.tsv |
| A |    global.a   |   0.2 |
| B | global.b |    0.4 |

### Character Multipliers
| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Strength | multi.strength | 0.8 |
| Dexterity | multi.dexterity | 0.9 |
| Expertise | multi.expertise | 0.9 |
| Resistance | multi.resistance | 1.2 |
| Life | multi.life | 1.1 |

### Cut Conditions

| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Max number of generations |  cut.maxgenerations | 200 |
| Percentage of unchanged population between two generations |    cut.structure   |   0.8 |
| Number of generations to evaluate if fitness doesn't improve (using mean fitness) | cut.contentmean |    10 |
| Number of generations to evaluate if fitness doesn't improve (using max fitness) | cut.contentmax |    10 |
| Maximum fitness wanted | cut.maxfitness |    0.9 |

**NOTE:** If this parameter is present, the cut condition will be enforced. For example, if the config file has the `cut.contentmax` and `cut.structure` keys, the cut conditions applied are Content Max and Structure.

### Selection
| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Selection Method 1 | selection.method1 |    elite |
| Selection Method 2 | selection.method2 |    roulette |


#### Possible method values
| Method   |      Key      |
|:-------------:|:-------------:|
| Boltzmann Selector | boltzmann |
| Deterministic Tournament | deterministic |
| Elite Selector | elite |
| Random Distinct Selector | randomd |
| Random Selector | random |
| Ranking Selector | ranking |
| Roulette Selector | roulette |
| Stochastic Tournament | stochastic |
| Universal Selector | universal |

### Replacement
| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Replacement Method 1 | replacement.method1 |    batch |
| Replacement Method 2 | replacement.method2 |    generational |

#### Possible method values
| Method   |      Key      |
|:-------------:|:-------------:|
| Batch Replacer | batch |
| Generational Replacer | generational |
| Iterative Replacer | iterative |

### Reproduction
| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Reproduction Method | reproduction.method |    anular |

#### Possible method values
| Method   |      Key      |
|:-------------:|:-------------:|
| Anular Cross | anular |
| One Point Cross | onepoint |
| Two Point Cross | twopoints |
| Uniform Cross | uniform |

### Mutation
| Paramter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Mutation Method | mutation.method |    uniform |

#### Possible method values
| Method   |      Key      |
|:-------------:|:-------------:|
| Uniform Mutator | uniform |

## Credits

* [Marzoratti, Luis](https://github.com/lmarzora)
* [Soncini, Lucas](https://github.com/lsoncini)
* [Fraga, Matias](https://github.com/matifraga)
* [De Lucca, Tomas](https://github.com/tomidelucca)

</br>

![Raptor](http://files.tomidelucca.me/images/raptor-black-100.png)