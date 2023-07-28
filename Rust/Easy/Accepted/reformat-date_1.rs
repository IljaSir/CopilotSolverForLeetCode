impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut date = date.split_whitespace().collect::<Vec<&str>>();
        let month = match date[1] {
            "Jan" => "01",
            "Feb" => "02",
            "Mar" => "03",
            "Apr" => "04",
            "May" => "05",
            "Jun" => "06",
            "Jul" => "07",
            "Aug" => "08",
            "Sep" => "09",
            "Oct" => "10",
            "Nov" => "11",
            "Dec" => "12",
            _ => panic!("Wrong month"),
        };
        let mut day = date[0].to_string();
        day.pop();
        day.pop();
        if day.len() == 1 {
            day = format!("0{}", day);
        }
        format!("{}-{}-{}", date[2], month, day)
    }
}