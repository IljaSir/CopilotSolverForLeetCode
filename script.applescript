% This script might need to be customized for the specific screen that you are using

on get_num_of_lines(filename)
    return do shell script "wc -l < "& filename &"" as text
end get_num_of_lines

on get_num_of_chars(filename)
    return do shell script "wc -c < "& filename &"" as text
end get_num_of_chars

to save_file()
    tell application "System Events" to keystroke "s" using {command down}
end save_file

to close_vs_tab()
    tell application "System Events" to keystroke "w" using {command down}
end close_vs_tab

to go_to_line_start()
    tell application "System Events" to keystroke "a" using {control down}
end go_to_line_start

to copilot_ask_to_generate()
    tell application "System Events" to key code 42 using {option down}
end copilot_ask_to_generate

on click_accept_solution(x_coord)
    -- tell application "System Events" to click at {x_coord, 115}
    tell app "Visual Studio Code"
        do shell script "cliclick c:" & "" & x_coord & ",115"
    end tell
end click_accept_solution

to select_all()
    tell application "System Events" to keystroke "a" using {command down}
end select_all

to copy_selected()
    tell application "System Events" to keystroke "c" using {command down}
end copy_selected

on write_to_file_from_clipboard(file_name)
    do shell script "pbpaste > " & file_name & ""
end write_to_file_from_clipboard

to click_anywhere_in_vs()
    tell app "Visual Studio Code"
        do shell script "cliclick c:" & "500,115"
    end tell
end click_anywhere_in_vs

to call_copilot()
    tell application "System Events" to key code 76 using {control down}
end call_copilot

on go_to_proper_line(lang)
    tell application "System Events" to key code 125 using {command down}
    if (lang = "C++") or (lang = "Rust") or (lang = "Java") then
        tell application "System Events" to key code 126
        tell application "System Events" to key code 126
    end if
end go_to_proper_line

on run argv
    set click_x_coord to 1210
    -- set flag to true
    set file_name to "" & item 1 of argv & "" as text
    set lang to "" & item 2 of argv & "" as text
    set write_copilot_solutions_to to "" & item 3 of argv & "" as text
    -- set init_num_of_lines to get_num_of_lines(file_name) as number
    set init_num_of_chars to get_num_of_chars(file_name) as number
    
    tell app "Visual Studio Code" to open file_name
    tell app "Visual Studio Code" to activate
    delay 1
    -- go_to_proper_line(lang)
    -- delay 3
    set i to 1
    repeat while true
        go_to_proper_line(lang)
        go_to_line_start()
        delay 2 -- 5
        -- repeat 2 times
            -- copilot_ask_to_generate()
            -- tell application "System Events" to key code 48
        call_copilot()
        set delay_time to 7 + 2*i
        delay delay_time
        -- set click_x_coord to click_x_coord + (i - 1) * 10
        select_all()
        copy_selected()
        delay 1
        write_to_file_from_clipboard(write_copilot_solutions_to)
        close_vs_tab()
        -- click_accept_solution(click_x_coord)
        delay 1
        click_anywhere_in_vs()

        set num_of_lines_in_solutions to get_num_of_lines(write_copilot_solutions_to) as number
        -- log "Number of lines in solution is " & num_of_lines_in_solutions & ""
        if (num_of_lines_in_solutions > 10) then
            exit repeat
        end if

        set i to i+1
        if (i = 6) then
            log("Failed to solve: " & file_name & "")
            exit repeat
        end if

    end repeat
    close_vs_tab()
end run

