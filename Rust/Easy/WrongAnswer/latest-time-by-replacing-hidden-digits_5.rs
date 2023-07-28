impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut res = vec!['?'; 5];
        for (i, c) in time.chars().enumerate() {
            if c == '?' {
                res[i] = match i {
                    0 => {
                        if time[1..].chars().any(|c| c == '0' || c == '1' || c == '2' || c == '3') {
                            '2'
                        } else {
                            '1'
                        }
                    }
                    1 => {
                        if res[0] == '2' {
                            '3'
                        } else {
                            '9'
                        }
                    }
                    2 => ':',
                    3 => '5',
                    4 => '9',
                    _ => unreachable!(),
                }
            } else {
                res[i] = c;
            }
        }
        res.into_iter().collect()
    }
}