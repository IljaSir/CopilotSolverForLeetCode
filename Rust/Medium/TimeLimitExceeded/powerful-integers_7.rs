impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        
        let mut set = std::collections::HashSet::new();
        let mut x_powers = vec![1];
        let mut y_powers = vec![1];
        while x_powers.last().unwrap() < &bound {
            let last = x_powers.last().unwrap();
            x_powers.push(last * x);
        }
        while y_powers.last().unwrap() < &bound {
            let last = y_powers.last().unwrap();
            y_powers.push(last * y);
        }
        for x_power in x_powers {
            for y_power in &y_powers {
                let sum = x_power + y_power;
                if sum <= bound {
                    set.insert(sum);
                }
            }
        }
        set.into_iter().collect()
    }
}