impl Solution {
    pub fn fair_candy_swap(alice_sizes: Vec<i32>, bob_sizes: Vec<i32>) -> Vec<i32> {
        
        let (mut alice, mut bob) = (0, 0);
        let (mut alice_set, mut bob_set) = (std::collections::HashSet::new(), std::collections::HashSet::new());
        for candy in alice_sizes {
            alice += candy;
            alice_set.insert(candy);
        }
        for candy in bob_sizes {
            bob += candy;
            bob_set.insert(candy);
        }
        let diff = (alice - bob) / 2;
        for candy in alice_set {
            if bob_set.contains(&(candy - diff)) {
                return vec![candy, candy - diff];
            }
        }
        vec![]
    }
}