impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login = login_time.split(":").collect::<Vec<&str>>();
        let mut logout = logout_time.split(":").collect::<Vec<&str>>();
        let login_hour = login[0].parse::<i32>().unwrap();
        let login_minute = login[1].parse::<i32>().unwrap();
        let logout_hour = logout[0].parse::<i32>().unwrap();
        let logout_minute = logout[1].parse::<i32>().unwrap();
        let mut login_total_minute = login_hour * 60 + login_minute;
        let mut logout_total_minute = logout_hour * 60 + logout_minute;
        if logout_total_minute < login_total_minute {
            logout_total_minute += 24 * 60;
        }
        let mut count = 0;
        for i in login_total_minute..logout_total_minute {
            if (i - 15) % 15 == 0 {
                count += 1;
            }
        }
        count           } else if minute >= 15 {
                minute = 30;
                round = round + 1;
            } else {
                minute = 15;
                round = round + 1;
            }
            if hour == 24 {
                hour = 0;
            }
        }
        return round;
    }
}