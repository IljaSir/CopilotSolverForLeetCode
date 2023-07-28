impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut date = date.split_whitespace().collect::<Vec<&str>>();
        let mut day = date[0].trim_end_matches(|c: char| !c.is_ascii_digit()).to_string();
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
            _ => "",
        };
        if day.len() == 1 {
            day = format!("0{}", day);
        }
        format!("{}-{}-{}", date[2], month, day)
    }
}