/**
 * Generics for that sweet compile time errors
 *
 * Type checking can't be done with generics they are compile time (Type Erasure)
 *
 * Generics don't make it to runtime
 *
 * upperbounds - <T: Player> which is <T extends Player> in typescript is called an `Under bounds`
 *
 * invariance - expects the exact type ignores upper bound types. e.g. MutableList
 *
 * covariance - allows only sub-classes of a type, usually the specified upper bounds type, applied using `out` keyword | | DOWN THE INHERITANCE TREE
 *
 * covariance can have errors because it allows subtypes and subtypes might have override the supertype properties.
 *
 * contravariance - opposite of covariance, accepts only super-classes of a type, usually the upper bounds type, applied using `in` keyword | UP THE INHERITANCE TREE
 *
 * To prevent type erasure at compile time, the `reified` keyword can be used. `reified` keyword can only be used by inline functions.
 */

