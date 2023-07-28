impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut count = vec![0; 5];
        let mut ans = 0;
        let mut frogs = 0;
        for c in croak_of_frogs.chars() {
            let i = match c {
                'c' => 0,
                'r' => 1,
                'o' => 2,
                'a' => 3,
                'k' => 4,
                _ => unreachable!(),
            };
            count[i] += 1;
            if i == 0 {
                frogs += 1;
            } else if count[i] > count[i - 1] {
                return -1;
            }
            if i == 4 {
                frogs -= 1;
            }
            ans = ans.max(frogs);
        }
        if count[0] == count[1] && count[1] == count[2] && count[2] == count[3] && count[3] == count[4] {
            ans
        } else {
            -1
        }
    }
}