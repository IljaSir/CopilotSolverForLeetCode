impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut count = 0;
        let mut time = time.chars().collect::<Vec<char>>();
        for i in 0..=1 {
            let mut num = time[i];
            if num == '?' {
                if i == 0 {
                    num = if time[1] == '?' || time[1] <= '3' { '2' } else { '1' };
                } else {
                    num = if time[0] == '?' || time[0] <= '1' { '9' } else { '3' };
                }
            }
            for j in 3..=4 {
                let mut num2 = time[j];
                if num2 == '?' {
                    num2 = '5';
                }
                count += if i == 0 && j == 3 {
                    if num <= '1' {
                        2
                    } else if num <= '2' {
                        1
                    } else {
                        0
                    }
                } else if i == 0 && j == 4 {
                    if num <= '1' {
                        10
                    } else if num <= '2' {
                        4
                    } else {
                        0
                    }
                } else if i == 1 && j == 3 {
                    if num <= '1' {
                        10
                    } else if num <= '2' {
                        4
                    } else {
                        0
                    }
                } else {
                    if num <= '1' {
                        2
                    } else if num <= '2' {
                        1
                    } else {
                        0
                    }
                } * if j == 3 {
                    1
                } else if num2 <= '4' {
                    6
                } else {
                    4
                };
            }
        }
        count
    }
}