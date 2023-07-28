impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in answers {
            match map.get_mut(&i) {
                Some(v) => {
                    *v += 1;
                    if *v > i + 1 {
                        map.remove(&i);
                        count += i + 1;
                    }
                }
                None => {
                    map.insert(i, 1);
                }
            }
        }
        for (k, v) in map {
            count += k + 1;
        }
        count
    }
}