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

| Parameter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Gear Data |  global.data | fulldata |
| A |    global.a   |   0.3 |
| B | global.b |    0.3 |
| N | global.N |    1000 |

### Character Features
| Parameter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Heir | multi.heir | warrior |
| Strength | multi.strength | 0.8 |
| Dexterity | multi.dexterity | 0.9 |
| Expertise | multi.expertise | 0.9 |
| Resistance | multi.resistance | 1.2 |
| Life | multi.life | 1.1 |

### Cut Conditions

| Parameter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Max number of generations |  cut.maxgenerations | 10000 |
| Percentage of unchanged population between two generations |    cut.structure   |   0.8 |
| Number of generations to evaluate if fitness doesn't improve (using mean fitness) | cut.contentmean |    1500 |
| Number of generations to evaluate if fitness doesn't improve (using max fitness) | cut.contentmax |    3000 |
| Maximum fitness wanted | cut.maxfitness |    30 |

**NOTE:** If this parameter is present, the cut condition will be enforced. For example, if the config file has the `cut.contentmax` and `cut.structure` keys, the cut conditions applied are Content Max and Structure.

### Selection
| Parameter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Selection Temperature | selection.temperature |    0.25 |
| Selection Children Size | selection.m |    2 |
| Selection Probability | selection.probability |    0.75 |
| Parent Selection Method 1 | selection.parentMethod1 |    elite |
| Parent Selection Method 2 | selection.parentMethod2 |    boltzmann |
| Children Selection Method 1 | selection.childrenMethod1 |    elite |
| Children Selection Method 2 | selection.childrenMethod2 |    roulette |

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
| Parameter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Replacement Children Size | replacement.k |    500 |
| Replacement Method | replacement.method |    batch |

#### Possible method values
| Method   |      Key      |
|:-------------:|:-------------:|
| Iterative Replacer (Method 1) | iterative |
| Batch Replacer (Method 2) | batch |
| Generational Replacer (Method 3) | generational |

### Reproduction
| Parameter   |      Value in config file      |  Example |
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
| Parameter   |      Value in config file      |  Example |
|:----------:|:-------------:|:------:|
| Mutation Probability | mutation.probability |    0.3 |
| Mutation Minimum Height | mutation.minHeight |    1.3 |
| Mutation Maximum Height | mutation.maxHeight |    2.0 |
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
