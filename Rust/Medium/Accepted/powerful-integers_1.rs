impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut set = std::collections::HashSet::new();
        let mut i = 0;
        let mut j = 0;
        loop {
            let a = x.pow(i);
            if a > bound {
                break;
            }
            j = 0;
            loop {
                let b = y.pow(j);
                if a + b > bound {
                    break;
                }
                set.insert(a + b);
                if y == 1 {
                    break;
                }
                j += 1;
            }
            if x == 1 {
                break;
            }
            i += 1;
        }
        set.into_iter().collect()
    }
}